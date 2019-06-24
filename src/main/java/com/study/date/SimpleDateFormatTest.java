package main.java.com.study.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: whb
 * @date: 2019/6/12 15:19
 * @description: SimpleDateFormat工具类测试
 */
public class SimpleDateFormatTest {


    private final static SimpleDateFormat singleSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat multiSdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        //单线程下直接这么使用是没有问题的
        System.out.println(singleSdf.format(new Date()));

        /**
         * 多线程下有线程安全问题
         * 创建30个线程，去转化不同的时间字符串，然后做打印输出。
         * 因为SimpleDateFormat定义为了共享的，所以其类里的属性calendar也是多个线程共享的，这就造成了线程安全问题。
         */
        /*for (int i = 1; i < 31; i++) {
            int j = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-05-" + j;
                    date = multiSdf.parse(s);
                    System.out.println("" + j + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }*/

        /**
         * 解决方案一：加锁
         */
        for (int i = 1; i < 31; i++) {
            int j = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-05-" + j;
                    synchronized (SimpleDateFormatTest.class) {
                        date = multiSdf.parse(s);
                    }
                    System.out.println("" + j + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        /**
         *解决方案二：每次都创建新的SimpleDateFormat实例，保证SimpleDateFormat实例不被共享
         */
        for (int i = 1; i < 31; i++) {
            int j = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-05-" + j;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    date = sdf.parse(s);
                    System.out.println("" + j + ":" + date.getDate());
                    sdf = null;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        /**
         * 解决方案三：使用LocalThread
         */
        for (int i = 1; i < 31; i++) {
            int j = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-06-" + j;
                    date = threadLocal.get().parse(s);
                    System.out.println("" + j + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        /**
         * 解决方案四：使用DateTimeFormatter
         */
        for (int i = 1; i < 31; i++) {
            int j = i;
            new Thread(() -> {
                //不这么写会报错.当dd小于10时，"dd" 解析失败，前面加上0则解析成功.
                String s = "2019-06-" + (j < 10 ? "0" + j : j);
                LocalDate localDate = LocalDate.parse(s, dtf);
                System.out.println("" + j + ":" + localDate.getDayOfMonth());
            }).start();
        }
    }

    //使用threadLocal解决
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    //使用DateTimeFormatter
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
