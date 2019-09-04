package main.java.com.study.designPatterns.adapter.objectAdapter.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 15:40
 * @description: 测试对象适配
 */
public class TestObjectAdapter {

    public static void main(String[] args) {
        //需要先创建一个被适配类的对象作为参数
        Target mAdapter = new Adapter(new Adaptee());
        mAdapter.request();
    }
}
