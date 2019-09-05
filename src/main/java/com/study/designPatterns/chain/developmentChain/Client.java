package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:54
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        Engineer xiaoming = new Builder()
                .addEngineer(new JuniorEngineer())
                .addEngineer(new MidEngineer())
                .addEngineer(new SeniorEngineer())
                .addEngineer(new ProfessionalEngineer())
                .build();
        IProject easyProject = new EasyProject();
        IProject normalProject = new NormalProject();
        IProject hardProject = new HardProject();
        IProject tooHardProject = new TooHardProject();
        IProject beyondProject = new BeyondProject();

        if (!xiaoming.doWork(easyProject)) {
            System.out.println("tell Product Manager: easy project can not complete");
        }
        if (!xiaoming.doWork(normalProject)) {
            System.out.println("tell Product Manager: normal project can not complete");
        }
        if (!xiaoming.doWork(hardProject)) {
            System.out.println("tell Product Manager: hard project can not complete");
        }
        if (!xiaoming.doWork(tooHardProject)) {
            System.out.println("tell Product Manager: too hard project can not complete");
        }
        if (!xiaoming.doWork(beyondProject)) {
            System.out.println("tell Product Manager: beyond project can not complete: " + beyondProject.difficulty());
        }
    }
}
