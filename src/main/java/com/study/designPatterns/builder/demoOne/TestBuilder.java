package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:48
 * @description: 测试类
 */
public class TestBuilder {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        //华硕电脑
        Builder asusBuilder = new ASUSComputerBuilder();
        Computer asusComputer = director.construct(asusBuilder);
        System.out.println(asusComputer.toString());
        //戴尔电脑--通过反射机制创建具体建造者
        try {
            Class clazz = Class.forName("main.java.com.study.designPatterns.builder.demoOne.DellComputerBuilder");
            Builder dellBuilder = (DellComputerBuilder) clazz.newInstance();
            Computer dellComputer = director.construct(dellBuilder);
            System.out.println(dellComputer.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
