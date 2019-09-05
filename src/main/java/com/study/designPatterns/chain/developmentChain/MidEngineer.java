package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 15:04
 * @description: 中级工程师
 */
public class MidEngineer extends Engineer {

    @Override
    protected boolean filterProject(IProject project) {
        return project.difficulty() <= IProject.NORMAL;
    }

    @Override
    protected boolean writeCode(IProject project) {
        System.out.println("中级工程师完成需求难度： " + project.difficulty());
        return true;
    }
}