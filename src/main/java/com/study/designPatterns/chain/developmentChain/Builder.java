package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 15:00
 * @description: 定义建造者
 */
public class Builder {
    private Engineer mFirst;
    private Engineer mLast;

    /**
     * 添加工程师
     *
     * @param engineer
     * @return
     */
    public Builder addEngineer(Engineer engineer) {
        if (this.mFirst == null) {
            this.mFirst = this.mLast = engineer;
        } else {
            this.mLast.mSuccessor = engineer;
            this.mLast = engineer;
        }
        return this;
    }

    public Engineer build() {
        return this.mFirst;
    }
}
