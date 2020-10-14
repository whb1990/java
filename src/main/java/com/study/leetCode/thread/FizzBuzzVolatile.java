package main.java.com.study.leetCode.thread;

import java.util.function.IntConsumer;

/**
 * @author： whb
 * @description： LeetCode-1195-交替打印字符串
 * @date： 2020-10-14 17:01
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
public class FizzBuzzVolatile {
    private int n;
    private volatile int flag = 0;

    public FizzBuzzVolatile(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            // 是3的倍数且不是5的倍数
            if (i % 5 != 0) {
                while (flag != 1) {
                    Thread.sleep(1);
                }
                printFizz.run();
                // 将控制权交还给number()方法
                flag = 0;
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            // 不是3的倍数且是5的倍数
            if (i % 3 != 0) {
                while (flag != 2) {
                    Thread.sleep(1);
                }
                printBuzz.run();
                // 控制权交还给number()方法
                flag = 0;
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            // 是3的倍数且是5的倍数
            while (flag != 3) {
                Thread.sleep(1);
            }
            printFizzBuzz.run();
            // 控制权交还给number()方法
            flag = 0;
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (flag != 0) {
                Thread.sleep(1);
            }
            if (i % 3 == 0 && i % 5 == 0) {
                flag = 3;
            } else if (i % 5 == 0) {
                flag = 2;
            } else if (i % 3 == 0) {
                flag = 1;
            }
            // 不是3的倍数且不是5的倍数
            else {
                printNumber.accept(i);
                flag = 0;
            }
        }
    }
}
