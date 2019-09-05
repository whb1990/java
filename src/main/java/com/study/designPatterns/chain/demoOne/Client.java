package main.java.com.study.designPatterns.chain.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 17:25
 * @description: 测试
 */
public class Client {
    public static void main(String[] args) {
        Handler zhangsan = new Director("张三");
        Handler lisi = new Manager("李四");
        Handler wangwu = new TopManager("王五");

        // 创建责任链
        zhangsan.setNextHandler(lisi);
        lisi.setNextHandler(wangwu);

        // 发起请假申请
        boolean result1 = zhangsan.process(new LeaveRequest("小博爷", 1));
        System.out.println("最终结果：" + result1 + "\n");

        boolean result2 = zhangsan.process(new LeaveRequest("小博爷", 4));
        System.out.println("最终结果：" + result2 + "\n");

        boolean result3 = zhangsan.process(new LeaveRequest("小博爷", 8));
        System.out.println("最终结果：" + result3 + "\n");
    }
}
