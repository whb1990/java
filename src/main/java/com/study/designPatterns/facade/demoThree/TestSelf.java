package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:39
 * @description: 自己泡茶喝
 */
public class TestSelf {
    public static void main(String[] args) {
        Man zhangsan = new Man("张三");
        KettleService kettleService1 = new KettleService();
        TeasetService teasetService1 = new TeasetService();
        Water water1 = new Water();
        TeaLeaf teaLeaf1 = new TeaLeaf("西湖龙井");
        kettleService1.waterBurning(zhangsan.getName(), water1, 4);
        TeaWater teawater1 = teasetService1.makeTeaWater(zhangsan.getName(), water1, teaLeaf1);
        zhangsan.drink(teawater1);
        System.out.println();

        Man lisi = new Man("李四");
        KettleService kettleService2 = new KettleService();
        TeasetService teasetService2 = new TeasetService();
        Water water2 = new Water(10, 15);
        TeaLeaf teaLeaf2 = new TeaLeaf("碧螺春");
        kettleService2.waterBurning(lisi.getName(), water2, 4);
        TeaWater teawater2 = teasetService2.makeTeaWater(lisi.getName(), water2, teaLeaf2);
        lisi.drink(teawater2);
    }
}
