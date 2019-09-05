package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:55
 * @description: 需求接口
 */
public interface IProject {
    /**
     * 常量值标识需求的难易程度
     */
     int EASY = 0;
     int NORMAL = 1;
     int HARD = 2;
     int TOO_HARD = 3;
     int BEYOND = 4;

    /**
     * 需求难度
     *
     * @return
     */
    int difficulty();
}
