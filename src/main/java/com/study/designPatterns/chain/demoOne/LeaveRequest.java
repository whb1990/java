package main.java.com.study.designPatterns.chain.demoOne;

/**
 * @author: whb
 * @date: 2019/9/5 17:20
 * @description: 请假信息类
 */
public class LeaveRequest {
    /**
     * 请假人姓名
     */
    private String name;

    /**
     * 请假天数
     */
    private int numOfDays;

    public LeaveRequest(String name, int numOfDays) {
        this.name = name;
        this.numOfDays = numOfDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }
}
