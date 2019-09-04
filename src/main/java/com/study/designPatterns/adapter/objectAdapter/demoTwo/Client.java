package main.java.com.study.designPatterns.adapter.objectAdapter.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 15:30
 * @description: 假设要制作一个笔记本电源适配器（Adapter），能够将家用 220V 交流电（Adaptee）转成直流12V（Target）。
 */
public class Client {
    public static void main(String[] args) {
        //Adapter对象
        Adapter adapter = new Adapter();
        //进行转化
        int result = adapter.output12();
        System.out.println("输出电压: " + result);
    }
}


