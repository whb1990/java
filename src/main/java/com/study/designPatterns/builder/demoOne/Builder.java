package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:44
 * @description: 抽象建造者
 */
public abstract class Builder {
    /**
     * 产品角色
     */
    protected Computer computer = new Computer();

    public abstract void buildBrand();

    public abstract void buildCPU();

    public abstract void buildMainBoard();

    public abstract void buildHardDisk();

    public abstract void buildDisplayCard();

    public abstract void buildPower();

    public abstract void buildMemory();

    /**
     * 制造电脑
     *
     * @return
     */
    public Computer createComputer() {
        return computer;
    }
}
