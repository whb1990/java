package main.java.com.study.designPatterns.simpleFactoryPattern.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 15:20
 * @description: 工厂类
 */
public class ComputerFactory {

    /**
     * 生产电脑
     *
     * @param type
     * @return
     */
    public static Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "lenovo":
                computer = new LenovoComputer();
                break;
            case "hp":
                computer = new HpComputer();
                break;
            case "asus":
                computer = new AsusComputer();
                break;
        }
        return computer;
    }
}
