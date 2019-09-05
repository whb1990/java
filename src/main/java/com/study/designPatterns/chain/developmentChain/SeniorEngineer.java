package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 15:04
 * @description: 高级工程师
 */
public class SeniorEngineer extends Engineer {

    @Override
    protected boolean filterProject(IProject project) {
        return project.difficulty() <= IProject.HARD;
    }

    @Override
    protected boolean writeCode(IProject project) {
        System.out.println("高级工程师完成需求难度： " + project.difficulty());
        return true;
    }
}