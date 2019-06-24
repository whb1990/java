package main.java.com.study.designPatterns.iterator.caseTwo;

/**
 * @author: whb
 * @date: 2019/6/14 9:15
 * @description: 定义迭代器接口
 */
public interface Iterator {

    /**
     * 取下一元素
     *
     * @return
     */
    public Object next();

    /**
     * 判断是否有下一个元素
     *
     * @return
     */
    public boolean hasNext();
}
