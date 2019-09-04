package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:37
 * @description: 人喝茶水
 */
public class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public void drink(TeaWater teawater) {
        System.out.println(name + " 喝了" + teawater.getTeawater());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
