package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:59
 * @description: 定义需要更改需求的需求
 */
public class BeyondProject implements IProject {

    @Override
    public int difficulty() {
        return IProject.BEYOND;
    }
}
