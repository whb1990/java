package main.java.com.study.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: whb
 * @date: 2019/8/19 15:07
 * @description: InetAddress测试类
 * InetAddress:类的主要作用是封装IP及DNS，因为这个类没有构造器，所以我们要用他的一些方法来获得对象常用的有
 * <p>
 * 1、使用getLocalHost方法为InetAddress创建对象；
 * <p>
 * 2、根据域名得到InetAddress对象
 * <p>
 * 3、根据ip得到InetAddress对象
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // 使用getLocalHost方法为InetAddress创建对象；
        //获得本机的InetAddress对象
        InetAddress add = InetAddress.getLocalHost();
        //返回本机IP地址
        System.out.println(add.getHostAddress());
        //输出主机名
        System.out.println(add.getHostName());
        //根据域名得到InetAddress对象
        add = InetAddress.getByName("www.baidu.com");
        //返回百度服务器的IP地址
        System.out.println(add.getHostAddress());
        //输出主机名
        System.out.println(add.getHostName());
        //根据ip得到InetAddress对象；
        add = InetAddress.getByName("111.13.100.91");
        System.out.println(add.getHostAddress());
        //如果ip地址存在，并且DNS给你解析就会输出
        System.out.println(add.getHostName());
    }

}
