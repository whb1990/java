package main.java.com.study.designPatterns.adapter.classAdapter.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 15:25
 * @description: 适配器类
 */
public class Adapter220V extends PowerPort220V implements Target{
    //
    //
    //
    //

    /**
     * 期待的插头要求调用convert_110v()，但原有插头没有
     * 因此适配器补充上这个方法名
     * 但实际上convert_110v()只是调用原有插头的output_220v()方法的内容
     * 所以适配器只是将output_220v()作了一层封装，封装成Target可以调用的convert_110v()而已
     */
    @Override
    public void convert_110v(){
        this.output_220v();
    }
}
