package main.java.com.study.limiter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author: whb
 * @date: 2019/9/6 15:18
 * @description: 令牌桶算法
 */
public class TokenLimiter {

    /**
     * 默认桶大小个数 即最大瞬间流量是64M
     */
    private static final int DEFAULT_BUCKET_SIZE = 1024 * 1024 * 64;

    /**
     * 一个桶的单位是1字节
     */
    private int everyTokenSize = 1;

    /**
     * 令牌最大数目
     */
    private int bucketSize;

    /**
     * 平均流量
     */
    private int avgFlowRate;

    /**
     * 队列来缓存桶数量
     */
    private ArrayBlockingQueue<Byte> tokenQueue = new ArrayBlockingQueue<Byte>(
            DEFAULT_BUCKET_SIZE);

    private ScheduledExecutorService scheduledExecutorService = Executors
            .newSingleThreadScheduledExecutor();

    private volatile boolean isStart = false;

    private ReentrantLock lock = new ReentrantLock(true);

    private static final byte A_CHAR = 'a';

    public TokenLimiter() {
    }

    public TokenLimiter(int bucketSize, int avgFlowRate) {
        this.bucketSize = bucketSize;
        this.avgFlowRate = avgFlowRate;
    }

    public TokenLimiter(int everyTokenSize, int bucketSize, int avgFlowRate) {
        this.everyTokenSize = everyTokenSize;
        this.bucketSize = bucketSize;
        this.avgFlowRate = avgFlowRate;
    }

    public void addTokens(Integer tokenNum) {

        // 若是桶已经满了，就不再家如新的令牌
        for (int i = 0; i < tokenNum; i++) {
            tokenQueue.offer(Byte.valueOf(A_CHAR));
        }
    }

    public TokenLimiter build() {

        start();
        return this;
    }

    /**
     * 获取足够的令牌个数
     *
     * @return
     */
    public boolean getTokens(byte[] dataSize) {
        //传输内容大小对应的桶个数
        int needTokenNum = dataSize.length / everyTokenSize + 1;

        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            //是否存在足够的桶数量
            boolean result = needTokenNum <= tokenQueue.size();
            if (!result) {
                return false;
            }

            int tokenCount = 0;
            for (int i = 0; i < needTokenNum; i++) {
                Byte poll = tokenQueue.poll();
                if (poll != null) {
                    tokenCount++;
                }
            }

            return tokenCount == needTokenNum;
        } finally {
            lock.unlock();
        }
    }

    public void start() {
        // 初始化桶队列大小
        if (bucketSize > 0) {
            tokenQueue = new ArrayBlockingQueue<Byte>(bucketSize);
        }
        // 初始化令牌生产者
        TokenProducer tokenProducer = new TokenProducer(avgFlowRate, this);
        //定时1s生产令牌
        scheduledExecutorService.scheduleAtFixedRate(tokenProducer, 0, 1,
                TimeUnit.SECONDS);
        isStart = true;
    }

    public void stop() {
        isStart = false;
        scheduledExecutorService.shutdown();
    }

    public boolean isStarted() {
        return isStart;
    }

    class TokenProducer implements Runnable {

        private int avgFlowRate;
        private TokenLimiter tokenLimiter;

        public TokenProducer(int avgFlowRate, TokenLimiter tokenLimiter) {
            this.avgFlowRate = avgFlowRate;
            this.tokenLimiter = tokenLimiter;
        }

        @Override
        public void run() {
            tokenLimiter.addTokens(avgFlowRate);
        }
    }

    public static TokenLimiter newBuilder() {
        return new TokenLimiter();
    }

    public TokenLimiter everyTokenSize(int everyTokenSize) {
        this.everyTokenSize = everyTokenSize;
        return this;
    }

    public TokenLimiter bucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
        return this;
    }

    public TokenLimiter avgFlowRate(int avgFlowRate) {
        this.avgFlowRate = avgFlowRate;
        return this;
    }

    private String stringCopy(String data, int copyNum) {
        StringBuilder sbuilder = new StringBuilder(data.length() * copyNum);
        for (int i = 0; i < copyNum; i++) {
            sbuilder.append(data);
        }
        return sbuilder.toString();
    }

    public static void main(String[] args) throws IOException,
            InterruptedException {
        TokenLimiter tokenLimiter = TokenLimiter.newBuilder().avgFlowRate(512)
                .bucketSize(1024).build();

        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("D:/ds_test")));
        // 四个字节
        String data = "xxxx";

        ExecutorService executor = Executors.newCachedThreadPool();
        //初始化
        IntStream.range(0, 1000).forEach(i -> {
            executor.submit(() -> {
                //每个线程需要一个令牌
                boolean token = tokenLimiter.getTokens("x".getBytes());
                if (token) {
                    System.out.println("token pass");
                } else {
                    System.out.println("token refuse");
                }
            });
        });
    }
}
