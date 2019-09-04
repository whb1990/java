package main.java.com.study.designPatterns.facade.demoTwo.useFacade;

/**
 * @author: whb
 * @date: 2019/9/4 22:22
 * @description: 80岁的老爷爷
 */
public class Grandpa {
    public static void main(String[] args) {
        ControllerFacade facade = new ControllerFacade();
        System.out.println("起床了");
        facade.on();

        System.out.println("准备睡觉了");
        facade.off();
        System.out.println("电器已全部关闭，可以安心睡觉了");

    }
}
