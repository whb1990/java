package main.java.com.study.designPatterns.simpleFactoryPattern.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 15:34
 * @description: 英雄联盟商城（也就是工厂）
 */
public class HeroFactory {

    /**
     * 根据条件获取英雄
     *
     * @param heroType
     * @return
     */
    public Heros getDifferentHero(String heroType) {
        Heros heros = null;
        switch (heroType) {
            case "Ashe":
                heros = new Ashe();
                break;
            case "MasterYi":
                heros = new MasterYi();
                break;
            case "Timor":
                heros = new Timor();
                break;
        }
        return heros;
    }
}
