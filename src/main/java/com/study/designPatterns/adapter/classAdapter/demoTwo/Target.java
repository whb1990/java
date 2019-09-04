package main.java.com.study.designPatterns.adapter.classAdapter.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 15:17
 * @description: 创建Target接口（期待得到的插头）：能输出110V（将220V转换成110V）
 */
public interface Target {

    /**
     * 将220V转换输出110V（原有插头（Adaptee）没有的）
     */
    void convert_110v();
}
