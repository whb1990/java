package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:57
 * @description: 定义简单需求
 */
public class EasyProject implements IProject {

    @Override
    public int difficulty() {
        return IProject.EASY;
    }
}
