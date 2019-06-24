package main.java.com.study.designPatterns.iterator.caseOne;

/**
 * @author: whb
 * @date: 2019/6/13 18:04
 * @description: 迭代器接口
 */
public interface Iterator<E> {

    /**
     * 获取下一个元素
     */
    E next();

    /**
     * 是否有下一个元素
     */
    boolean hasNext();
}
