package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:33
 * @description: 泡茶需要水
 */
public class Water {
    /**
     * 温度
     */
    private int temperature;
    /**
     * 容量
     */
    private int capacity;

    public Water() {
        this.temperature = 0;
        this.capacity = 10;
    }

    public Water(int temperature, int capacity) {
        this.temperature = temperature;
        this.capacity = capacity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
