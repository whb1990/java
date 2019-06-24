package main.java.com.study.designPatterns.chain.approvalChain;

/**
 * @author: whb
 * @date: 2019/6/13 10:41
 * @description: 审批人抽象类
 */
public abstract class Approver {

    //审批人姓名
    protected String name;

    //下一审批人
    protected Approver nextApprover;

    public Approver(String name) {
        this.name = name;
    }

    protected Approver setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
        // 返回下个审批人，链式编程。
        return this.nextApprover;
    }

    // 抽象审批方法由具体审批人子类实现
    public abstract void approve(int amount);

}
