package main.java.com.study.dataStructure.stack;

/**
 * @author: whb
 * @date: 2019/11/4 18:13
 * @description: 栈接口定义
 */
public interface Stack {
    /**
     * 入栈
     *
     * @param obj
     * @throws Exception
     */
    void push(Object obj) throws Exception;

    /**
     * 出栈
     */
    Object pop() throws Exception;

    /**
     * 获取栈顶元素
     */
    Object getTop() throws Exception;

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();
}
