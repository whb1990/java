package main.java.com.study.designPatterns.chain.approvalChain;

/**
 * @author: whb
 * @date: 2019/6/13 11:57
 * @description: CEO
 */
public class Ceo extends Approver {

    public Ceo(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 10000) {
            System.out.println("审批通过。【CEO：" + name + "】");
        } else {
            System.out.println("驳回申请。【CEO：" + name + "】");
        }
    }
}
