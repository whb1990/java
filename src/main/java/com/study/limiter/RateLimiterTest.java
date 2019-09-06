package main.java.com.study.limiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: whb
 * @date: 2019/9/6 15:22
 * @description: google开源工具包guava提供了限流工具类RateLimiter，该类基于“令牌桶算法”
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        //每秒生产两个令牌
        final RateLimiter rateLimiter = RateLimiter.create(20.0);

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                //随机休眠
                Random random = new Random();
                int r = random.nextInt(1000);
                try {
                    TimeUnit.MICROSECONDS.sleep(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //每个线程需要一个令牌
                boolean token = rateLimiter.tryAcquire();
                if (token) {
                    System.out.println("成功获取令牌");
                } else {
                    System.out.println("获取令牌失败");
                }
            });
        });
    }
}
