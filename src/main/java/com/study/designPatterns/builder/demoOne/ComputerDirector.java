package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:47
 * @description: 指挥者角色--指挥电脑制造过程
 */
public class ComputerDirector {
    public Computer construct(Builder builder) {
        // 逐步构建复杂产品对象
        Computer computer;
        builder.buildBrand();
        builder.buildCPU();
        builder.buildDisplayCard();
        builder.buildHardDisk();
        builder.buildMainBoard();
        builder.buildMemory();
        builder.buildPower();
        computer = builder.createComputer();
        return computer;
    }
}
