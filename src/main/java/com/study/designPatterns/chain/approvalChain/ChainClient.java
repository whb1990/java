package main.java.com.study.designPatterns.chain.approvalChain;

/**
 * @author: whb
 * @date: 2019/6/13 12:00
 * @description: 责任链模式客户端
 */
public class ChainClient {

    public static void main(String[] args) {
        Approver approver = new Staff("张飞");
        approver.setNextApprover(new Manager("关羽")).setNextApprover(new Ceo("刘备"));
        approver.approve(1000);

        approver.approve(4000);

        approver.approve(9000);

        approver.approve(10000);

        approver.approve(20000);
    }
}
