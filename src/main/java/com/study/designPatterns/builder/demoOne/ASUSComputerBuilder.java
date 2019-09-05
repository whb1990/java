package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:46
 * @description: 具体建造者--华硕电脑
 */
public class ASUSComputerBuilder extends Builder {
    @Override
    public void buildBrand() {
        computer.setBrand("华硕电脑");
    }

    @Override
    public void buildCPU() {
        computer.setCpu("Intel 第8代 酷睿");
    }

    @Override
    public void buildMainBoard() {
        computer.setMainBoard("华硕主板");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("256GB SSD");
    }

    @Override
    public void buildDisplayCard() {
        computer.setDisplayCard("MX150 独立2GB");
    }

    @Override
    public void buildPower() {
        computer.setPower("3芯 锂离子电池 65W AC适配器");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("1 x SO-DIMM  8GB");
    }
}