package main.java.com.study.designPatterns.adapter.classAdapter.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 15:30
 * @description: 客户端调用
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


