package main.java.com.study.designPatterns.templateMethod.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 10:51
 * @description: 抽象模板结构：炒菜的步骤
 */
public abstract class AbstractClass {
    /**
     * 模板方法，用来控制炒菜的流程 （炒菜的流程是一样的-复用）
     * 声明为final，不希望子类覆盖这个方法，防止更改流程的执行顺序
     */
    public final void cookProcess() {
        //第一步：倒油
        this.pourOil();
        //第二步：热油
        this.HeatOil();
        //第三步：倒蔬菜
        this.pourVegetable();
        //第四步：倒调味料
        this.pourSauce();
        //第五步：翻炒
        this.fry();
    }

    //定义结构里哪些方法是所有过程都是一样的可复用的，哪些是需要子类进行实现的

    /**
     * 第一步：倒油是一样的，所以直接实现
     */
    public void pourOil() {
        System.out.println("倒油");
    }

    /**
     * 第二步：热油是一样的，所以直接实现
     */
    public void HeatOil() {
        System.out.println("热油");
    }

    /**
     * 第三步：倒蔬菜是不一样的
     * 所以声明为抽象方法，具体由子类实现
     */
    public abstract void pourVegetable();

    /**
     * 第四步：倒调味料是不一样的
     * 所以声明为抽象方法，具体由子类实现
     */
    public abstract void pourSauce();

    /**
     * 第五步：翻炒是一样的，所以直接实现
     */
    public void fry() {
        System.out.println("炒啊炒啊炒到熟啊");
    }
}
