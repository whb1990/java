package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:34
 * @description: 泡茶需要茶叶
 */
public class TeaLeaf {
    /**
     * 茶叶名
     */
    private String teaName;

    public TeaLeaf(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
