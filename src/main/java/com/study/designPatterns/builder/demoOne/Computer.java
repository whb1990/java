package main.java.com.study.designPatterns.builder.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 11:42
 * @description: 产品角色--电脑
 */
public class Computer {
    /**
     * 品牌
     */
    private String brand;
    /**
     * cpu
     */
    private String cpu;
    /**
     * 主板
     */
    private String mainBoard;
    /**
     * 硬盘
     */
    private String hardDisk;
    /**
     * 显卡
     */
    private String displayCard;
    /**
     * 电源
     */
    private String power;
    /**
     * 内存
     */
    private String memory;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getDisplayCard() {
        return displayCard;
    }

    public void setDisplayCard(String displayCard) {
        this.displayCard = displayCard;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", cpu='" + cpu + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", displayCard='" + displayCard + '\'' +
                ", power='" + power + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
