package main.java.com.study.dataStructure.stack;

/**
 * @author: whb
 * @date: 2019/11/4 18:21
 * @description: 链式栈节点
 */
public class Node {
    /**
     * 数据
     */
    Object element;
    /**
     * 下一个节点的指针
     */
    Node next;

    /**
     * 头结点的构造方法
     */
    public Node(Node nextVal) {
        this.next = nextVal;
    }

    /**
     * 非头结点的构造方法
     */
    public Node(Object obj, Node nextVal) {
        this.element = obj;
        this.next = nextVal;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
