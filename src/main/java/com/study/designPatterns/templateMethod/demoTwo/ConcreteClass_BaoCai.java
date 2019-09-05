package main.java.com.study.designPatterns.templateMethod.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 11:00
 * @description: 创建具体模板--手撕包菜
 */
public class ConcreteClass_BaoCai extends  AbstractClass{
    @Override
    public void  pourVegetable(){
        System.out.println("下锅的蔬菜是包菜");
    }
    @Override
    public void  pourSauce(){
        System.out.println("下锅的酱料是辣椒");
    }
}
