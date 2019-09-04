package main.java.com.study.designPatterns.adapter.objectAdapter.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 15:33
 * @description: 适配器
 */
public class Adapter implements IDC12 {

    private AC220 ac220 = new AC220();

    @Override
    public int output12() {
        return this.ac220.output220() / 18;
    }
}
