package main.java.com.study.designPatterns.decorator.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 17:49
 * @description: 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        //实例化一个焦糖奶茶
        DrinkMiklTea drinkMiklTea = new CaramelMilkTea();
        System.out.println(drinkMiklTea.useMaterial() + " 总价：" + drinkMiklTea.getTotalPrice().toString());
        //添加布丁
        drinkMiklTea = new Pudding(drinkMiklTea);
        System.out.println(drinkMiklTea.useMaterial()+" 总价："+drinkMiklTea.getTotalPrice().toString());
        //添加青稞
        drinkMiklTea = new HighlandBarley(drinkMiklTea);
        System.out.println(drinkMiklTea.useMaterial()+" 总价："+drinkMiklTea.getTotalPrice().toString());
        //添加第二份青稞
        drinkMiklTea = new HighlandBarley(drinkMiklTea);
        System.out.println(drinkMiklTea.useMaterial()+" 总价："+drinkMiklTea.getTotalPrice().toString());
    }
}
