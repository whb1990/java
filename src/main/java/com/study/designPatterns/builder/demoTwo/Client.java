package main.java.com.study.designPatterns.builder.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 14:05
 * @description: 测试类
 */
public class Client {
    public static void main(String[] args) {
        //逛了很久终于发现一家合适的电脑店
        //找到该店的老板和装机人员
        Director director = new Director();
        Builder builder = new ConcreteBuilder();

        //沟通需求后，老板叫装机人员去装电脑
        director.construct(builder);

        //装完后，组装人员搬来组装好的电脑
        Computer computer = builder.getComputer();
        //组装人员展示电脑给小成看
        computer.show();
    }
}
