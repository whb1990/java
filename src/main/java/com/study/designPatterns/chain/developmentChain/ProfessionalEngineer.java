package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 15:05
 * @description: 资深工程师
 */
public class ProfessionalEngineer extends Engineer {

    @Override
    protected boolean filterProject(IProject project) {
        return project.difficulty() <= IProject.TOO_HARD;
    }

    @Override
    protected boolean writeCode(IProject project) {
        System.out.println("资深工程师完成需求难度：" + project.difficulty());
        return true;
    }
}
