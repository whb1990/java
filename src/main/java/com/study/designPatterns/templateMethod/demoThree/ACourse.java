package main.java.com.study.designPatterns.templateMethod.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 11:04
 * @description: 抽象类
 */
public abstract class ACourse {
    /**
     * 课程制作--模板方法
     */
    protected final void makeCourse() {
        this.makePPT();
        this.makeVideo();
        if (needWriteArticle()) {
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePPT() {
        System.out.println("1. 制作PPT");
    }

    final void makeVideo() {
        System.out.println("2. 制作视频");
    }

    final void writeArticle() {
        System.out.println("3. 编写课程笔记");
    }

    /**
     * 钩子方法
     *
     * @return
     */
    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();
}
