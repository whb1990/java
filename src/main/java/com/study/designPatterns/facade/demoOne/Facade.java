package main.java.com.study.designPatterns.facade.demoOne;

/**
 * @author: whb
 * @date: 2019/9/4 22:14
 * @description: 外观角色Facade
 */
public class Facade {
    /**
     * 子系统A
     */
    private SubSystemA a = new SubSystemA();
    /**
     * 子系统B
     */
    private SubSystemB b = new SubSystemB();
    /**
     * 子系统C
     */
    private SubSystemC c = new SubSystemC();

    // 对外接口
    public void doA() {
        this.a.doA();
    }

    // 对外接口
    public void doB() {
        this.b.doB();
    }

    // 对外接口
    public void doC() {
        this.c.doC();
    }
}
