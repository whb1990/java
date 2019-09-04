package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:42
 * @description: 茶馆喝茶测试类
 */
public class TeaHouseTest {
    public static void main(String[] args) {
        TeaHouseFacade teaHouseFacade = new TeaHouseFacade("老舍茶馆");

        Man zhangsan = new Man("张三");
        TeaWater teawater = teaHouseFacade.makeTea(1);
        zhangsan.drink(teawater);
        System.out.println();

        Man lisi = new Man("李四");
        TeaWater teawater1 = teaHouseFacade.makeTea(2);
        lisi.drink(teawater1);
    }
}
