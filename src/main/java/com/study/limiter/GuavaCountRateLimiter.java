package main.java.com.study.limiter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: whb
 * @date: 2019/9/6 15:12
 * @description: 缓存实现计数器限流算法
 * 使用Guava的Cache来存储计数器，过期时间设置为2秒（保证1秒内的计数器是有的），然后获取当前时间戳然后取秒数来作为KEY进行计数统计和限流。
 */
public class GuavaCountRateLimiter {

    /**
     * 缓存
     */
    private LoadingCache<Long, AtomicLong> counter =
            CacheBuilder.newBuilder()
                    .expireAfterWrite(2, TimeUnit.SECONDS)
                    .build(new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long seconds) throws Exception {
                            return new AtomicLong(0);
                        }
                    });

    /**
     * 限制每秒10
     */
    private long limit = 10;

    /**
     * 使用Guava的Cache来存储计数器，过期时间设置为2秒（保证1秒内的计数器是有的），然后我们获取当前时间戳然后取秒数来作为KEY进行计数统计和限流
     */
    public boolean tryAcquire() throws ExecutionException {
        //得到当前秒
        long currentSeconds = System.currentTimeMillis() / 1000;
        if (counter.get(currentSeconds).incrementAndGet() > limit) {
            System.out.println("refuse_request:count=" + counter.get(currentSeconds));
            return true;
        } else {
            System.out.println("pass_request:count=" + counter.get(currentSeconds));
            return false;
        }
    }

    public static void main(String[] args) {
        GuavaCountRateLimiter guavaCountRateLimiter = new GuavaCountRateLimiter();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                double random = (new Random()).nextDouble();
                long a = (long) (random * 1000);
                try {
                    //睡眠一下
                    Thread.sleep(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    guavaCountRateLimiter.tryAcquire();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
