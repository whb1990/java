package main.java.com.study.designPatterns.builder.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 14:02
 * @description: 定义指挥者角色：电脑城老板
 */
public class Director {
    /**
     * 指挥装机人员组装电脑
     *
     * @param builder
     */
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainboard();
        builder.buildHD();
    }
}
