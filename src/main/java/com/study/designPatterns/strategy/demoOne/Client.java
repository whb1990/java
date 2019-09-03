package main.java.com.study.designPatterns.strategy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 20:20
 * @description: 客户端调用
 */
public class Client {
    public static void main(String[] args) {
        SalesMan mSalesMan;

        //春节来了，使用春节促销活动
        System.out.println("对于春节：");
        mSalesMan = new SalesMan("A");
        mSalesMan.salesManShow();


        //中秋节来了，使用中秋节促销活动
        System.out.println("对于中秋节：");
        mSalesMan = new SalesMan("B");
        mSalesMan.salesManShow();

        //圣诞节来了，使用圣诞节促销活动
        System.out.println("对于圣诞节：");
        mSalesMan = new SalesMan("C");
        mSalesMan.salesManShow();
    }
}
