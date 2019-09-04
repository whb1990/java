package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:37
 * @description: 茶水
 */
public class TeaWater {
    private String teawater;

    public TeaWater(String teawater) {
        this.teawater = teawater;
    }

    public String getTeawater() {
        return teawater;
    }

    public void setTeawater(String teawater) {
        this.teawater = teawater;
    }
}
