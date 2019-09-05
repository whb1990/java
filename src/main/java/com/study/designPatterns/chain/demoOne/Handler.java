package main.java.com.study.designPatterns.chain.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 17:21
 * @description: 抽象处理者类，维护一个nextHandler属性，该属性为当前处理者的下一个处理者的引用
 */
public abstract class Handler {
    /**
     * 处理者姓名
     */
    protected String name;
    /**
     * 下一个处理者
     */
    protected Handler nextHandler;

    public Handler(String name) {
        this.name = name;
    }

    public abstract boolean process(LeaveRequest leaveRequest); // 处理请假

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
