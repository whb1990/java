package main.java.com.study.leetCode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author： whb
 * @description： LeetCode-1195-交替打印字符串
 * @date： 2020-10-14 16:39
 * 难度：中等
 * 标签：多线程
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class FizzBuzzSemaphore {
    private int n;
    /**
     * 四个线程第一次执行时，因为只有number信号量的计数器初始值为1，其余都为0，所以number线程先执行，
     * 让它不断判断接下来该哪个线程执行，并释放对应线程的信号量，对应线程执行一次循环后，释放number信号量，
     * 以便number线程继续判断。
     */
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private Semaphore number = new Semaphore(1);

    public FizzBuzzSemaphore(int n) {
        this.n = n;
    }

    /**
     * printFizz.run() outputs "fizz".
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                // 获取fizz信号量的一个许可
                fizz.acquire();
                printFizz.run();
                // 释放number信号量的一个许可
                number.release();
            }
        }
    }

    /**
     * printBuzz.run() outputs "buzz".
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                // 获取buzz信号量的一个许可
                buzz.acquire();
                printBuzz.run();
                // 释放number信号量的一个许可
                number.release();
            }
        }
    }

    /**
     * printFizzBuzz.run() outputs "fizzbuzz".
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            // 获取fizzbuzz信号量的一个许可
            fizzbuzz.acquire();
            printFizzBuzz.run();
            // 释放number信号量的一个许可
            number.release();
        }
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // 获取number信号量的一个许可
            number.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                // 释放fizzbuzz信号量的一个许可
                fizzbuzz.release();
            } else if (i % 3 == 0) {
                // 释放fizz信号量的一个许可
                fizz.release();
            } else if (i % 5 == 0) {
                // 释放buzz信号量的一个许可
                buzz.release();
            } else {
                printNumber.accept(i);
                // 释放number信号量的一个许可
                number.release();
            }
        }
    }
}
