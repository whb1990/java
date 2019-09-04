package main.java.com.study.designPatterns.adapter.classAdapter.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 15:14
 * @description: 测试类适配器
 */
public class TestClassAdapter {
    public static void main(String[] args) {
        Target mAdapter = new Adapter();
        mAdapter.request();
    }
}
