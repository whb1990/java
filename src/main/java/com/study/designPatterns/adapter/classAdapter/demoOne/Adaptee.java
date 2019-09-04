package main.java.com.study.designPatterns.adapter.classAdapter.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 15:11
 * @description: 源类
 */
public class Adaptee {
    /**
     * 需要适配的接口
     */
    public void specificRequest() {
        System.out.println("需要适配的接口...");
    }
}
