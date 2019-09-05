package main.java.com.study.designPatterns.templateMethod.demoThree;

/**
 * @author: whb
 * @date: 2019/9/5 11:07
 * @description: 测试
 */
public class TestCourse {
    public static void main(String[] args) {
        System.out.println("Java课程start---");
        ACourse javaCourse = new JavaCourse();
        javaCourse.makeCourse();
        System.out.println("Java课程end---\n");


        System.out.println("前端课程start---");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端课程end---");
    }
}
