package main.java.com.study.designPatterns.factory.abstracts.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/3 17:35
 * @description: 具体的工厂类-英雄
 */
public class HerosFactory extends HeroAndSkillFactory {

    @Override
    public Heros getHeros(String heroType) {
        Heros heros = null;
        switch (heroType) {
            case "Ashe":
                heros = new HeroAshe();
                break;
            case "MasterYi":
                heros = new HeroMasterYi();
                break;
            case "Timor":
                heros = new HeroTimor();
                break;
        }
        return heros;
    }

    @Override
    public Skills getSkills(String skillType) {
        return null;
    }
}
