package main.java.com.study.inet;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author: whb
 * @date: 2019/8/19 15:09
 * @description: InetSocketAddress测试类
 * InetSocketAddress类主要作用是封装端口 他是在在InetAddress基础上加端口，但它是有构造器的。
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress add = new InetSocketAddress("192.168.3.205", 9999);
        //输出主机名
        System.out.println(add.getHostName());
        //输出端口号
        System.out.println(add.getPort());
        //获得端口的ip
        InetAddress addr = add.getAddress();
        //返回ip地址
        System.out.println(addr.getHostAddress());
        //输出主机名
        System.out.println(addr.getHostName());
    }

}
