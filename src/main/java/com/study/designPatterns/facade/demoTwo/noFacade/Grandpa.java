package main.java.com.study.designPatterns.facade.demoTwo.noFacade;

/**
 * @author: whb
 * @date: 2019/9/4 22:20
 * @description: 80岁的老爷爷
 */
public class Grandpa {
    public static void main(String[] args){
        Light light = new Light();
        Television tv = new Television();
        Aircondition ad = new Aircondition();

        System.out.println("起床了");
        light.on();
        tv.on();
        ad.on();

        System.out.println("准备睡觉了");
        light.off();
        tv.off();
        ad.off();
        System.out.println("电器已全部关闭，可以安心睡觉了");

    }
}
