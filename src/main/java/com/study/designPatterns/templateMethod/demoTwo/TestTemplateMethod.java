package main.java.com.study.designPatterns.templateMethod.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 11:01
 * @description: 测试模板方法
 */
public class TestTemplateMethod {
    public static void main(String[] args) {
        //炒 - 手撕包菜
        ConcreteClass_BaoCai BaoCai = new ConcreteClass_BaoCai();
        BaoCai.cookProcess();

        //炒 - 蒜蓉菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
