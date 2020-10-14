package main.java.com.study.leetCode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author： whb
 * @description： LeetCode-1195-交替打印字符串
 * @date： 2020-10-14 16:50
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
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 */
public class FizzBuzzAtomic {
    private int n;
    private AtomicInteger num = new AtomicInteger(1);

    public FizzBuzzAtomic(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num.get() <= n) {
            int temp = num.get();
            // 是3的倍数且不是5的倍数
            if (temp % 3 == 0 && temp % 5 != 0) {
                printFizz.run();
                num.getAndIncrement();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num.get() <= n) {
            int temp = num.get();
            // 不是3的倍数且是5的倍数
            if (temp % 3 != 0 && temp % 5 == 0) {
                printBuzz.run();
                num.getAndIncrement();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num.get() <= n) {
            int temp = num.get();
            // 是3的倍数且是5的倍数
            if (temp % 3 == 0 && temp % 5 == 0) {
                printFizzBuzz.run();
                num.getAndIncrement();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num.get() <= n) {
            int temp = num.get();
            // 不是3的倍数且不是5的倍数
            if (temp % 3 != 0 && temp % 5 != 0) {
                printNumber.accept(temp);
                num.getAndIncrement();
            }
        }
    }
}
