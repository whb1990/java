package main.java.com.study.designPatterns.chain.developmentChain;

/**
 * @author: whb
 * @date: 2019/9/5 14:59
 * @description: 定义工程师
 */
public abstract class Engineer {
    public Engineer mSuccessor;

    /**
     * 开启工作
     *
     * @param project
     * @return
     */
    public final boolean doWork(IProject project) {
        boolean bRet = false;
        do {
            if (this.filterProject(project)) {
                bRet = this.writeCode(project);
                break;
            }
            if (this.mSuccessor != null) {
                bRet = this.mSuccessor.doWork(project);
                break;
            }
        } while (false);
        return bRet;
    }

    /**
     * 跳过需求传递给下一工程师
     *
     * @param project
     * @return
     */
    protected abstract boolean filterProject(IProject project);

    /**
     * 写代码
     *
     * @param project
     * @return
     */
    protected abstract boolean writeCode(IProject project);
}
