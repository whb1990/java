package main.java.com.study.designPatterns.iterator.caseTwo;

/**
 * @author: whb
 * @date: 2019/6/14 9:16
 * @description: 定义容器接口
 */
public interface Container {

    /**
     * 获取迭代器
     *
     * @return
     */
    Iterator getIterator();
}
