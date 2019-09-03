package main.java.com.study.designPatterns.factory.abstracts.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 17:08
 * @description: 抽象工厂类，定义具体工厂的公共接口
 */
public abstract class Factory {
    /**
     * 生产容器
     *
     * @return
     */
    public abstract AbstractProduct manufactureContainer();

    /**
     * 生产模具
     *
     * @return
     */
    public abstract AbstractProduct manufactureMould();
}
