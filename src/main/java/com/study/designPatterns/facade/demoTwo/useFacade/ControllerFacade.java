package main.java.com.study.designPatterns.facade.demoTwo.useFacade;

/**
 * @author: whb
 * @date: 2019/9/4 22:21
 * @description: 外观角色
 */
public class ControllerFacade {
    private Light light = new Light();
    private Television tv = new Television();
    private Aircondition ad = new Aircondition();

    public void on() {
        this.light.on();
        this.tv.on();
        this.ad.on();
    }

    public void off() {
        this.light.off();
        this.tv.off();
        this.ad.off();
    }
}
