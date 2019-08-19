package main.java.com.study.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author: whb
 * @date: 2019/8/15 21:40
 * @description: NIO测试
 */
public class NioTest {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        intBuffer.clear();

        int a = intBuffer.get();
        System.out.println(a);

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //清空
        byteBuffer.clear();
        //写入数据
        byteBuffer.put("hello".getBytes());
        //读数据之前的必备操作
        byteBuffer.flip();
        //数据是否读取完毕
        while (byteBuffer.hasRemaining()) {
            //读取数据
            System.out.println(byteBuffer.get() + "\t");
        }
        System.out.println();

    }
}
