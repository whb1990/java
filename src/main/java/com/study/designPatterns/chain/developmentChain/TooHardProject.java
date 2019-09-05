package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:58
 * @description: 定义巨难的需求
 */
public class TooHardProject implements IProject {

    @Override
    public int difficulty() {
        return IProject.TOO_HARD;
    }
}
