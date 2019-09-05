package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:46
 * @description: 具体建造者--戴尔
 */
public class DellComputerBuilder extends Builder {
    @Override
    public void buildBrand() {
        computer.setBrand("戴尔电脑");
    }

    @Override
    public void buildCPU() {
        computer.setCpu("i5-8300H 四核");
    }

    @Override
    public void buildMainBoard() {
        computer.setMainBoard("戴尔主板");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("1T + 128GB SSD");
    }

    @Override
    public void buildDisplayCard() {
        computer.setDisplayCard("GTX1060 独立6GB");
    }

    @Override
    public void buildPower() {
        computer.setPower("4芯 锂离子电池 180W AC适配器");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("4G + 4G");
    }
}
