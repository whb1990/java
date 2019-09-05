package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 15:03
 * @description: 初级工程师
 */
public class JuniorEngineer extends Engineer {

    @Override
    protected boolean filterProject(IProject project) {
        return project.difficulty() <= IProject.EASY;
    }

    @Override
    protected boolean writeCode(IProject project) {
        System.out.println("初级工程师完成需求难度 : " + project.difficulty());
        return true;
    }
}
