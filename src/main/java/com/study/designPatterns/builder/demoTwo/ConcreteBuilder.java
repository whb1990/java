package main.java.com.study.designPatterns.builder.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 14:04
 * @description: 定义具体建造者：装机人员
 */
public class ConcreteBuilder extends Builder {
    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.add("组装CPU");
    }

    @Override
    public void buildMainboard() {
        computer.add("组装主板");
    }

    @Override
    public void buildHD() {
        computer.add("组装主板");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
