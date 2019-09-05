package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:57
 * @description: 定义困难需求
 */
public class HardProject implements IProject{

    @Override
    public int difficulty() {
        return IProject.HARD;
    }
}
