package main.java.com.study.designPatterns.templateMethod.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 11:06
 * @description: Java课程
 */
public class JavaCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("4. 提供Java课程源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
