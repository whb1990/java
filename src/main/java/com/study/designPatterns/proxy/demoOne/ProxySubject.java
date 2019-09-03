package main.java.com.study.designPatterns.proxy.demoOne;

/**
 * @author: whb
 * @date: 2019/9/3 21:44
 * @description: 创建代理对象
 */
public class ProxySubject implements Subject {

    /**
     * 引用真实对象示例
     */
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buyMac() {
        //调用真实对象的方法，进行代理购买
        realSubject.buyMac();
        //代理对象额外的操作
        this.wrapMac();
    }

    public void wrapMac() {
        System.out.println("用盒子包装好mac...");
    }
}
