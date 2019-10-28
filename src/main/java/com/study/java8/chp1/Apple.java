package main.java.com.study.java8.chp1;

/**
 * @author: whb
 * @date: 2019/10/28 10:56
 * @description: 定义苹果
 */
public class Apple {

    /**
     * 颜色
     */
    private String color;

    /**
     * 重量
     */
    private double weight;

    public Apple() {
    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
