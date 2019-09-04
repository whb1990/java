package main.java.com.study.designPatterns.adapter.classAdapter.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 15:33
 * @description: 适配器
 */
public class Adapter extends AC220 implements IDC12 {
    @Override
    public int output12() {
        return super.output220() / 18;
    }
}
