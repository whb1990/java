package main.java.com.study.designPatterns.templateMethod.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 11:06
 * @description: 前端课程
 */
public class FECourse extends ACourse {
    private boolean needWriteArticleFlag = false;

    @Override
    void packageCourse() {
        System.out.println("4.1 提供课程的前端代码");
        System.out.println("4.2 提供课程的图片等多媒体素材");
    }

    public FECourse(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }
}
