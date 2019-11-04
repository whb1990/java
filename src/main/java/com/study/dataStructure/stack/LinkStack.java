package main.java.com.study.dataStructure.stack;

/**
 * @author: whb
 * @date: 2019/11/4 18:23
 * @description: 链式栈
 */
public class LinkStack implements Stack {

    /**
     * 栈顶指针
     */
    Node head;
    /**
     * 节点个数
     */
    int size;

    public LinkStack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 入栈
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void push(Object obj) throws Exception {
        head = new Node(obj, head);
        size++;
    }

    /**
     * 出栈
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈为空");
        }
        Object obj = head.getElement();
        head = head.getNext();
        size--;
        return obj;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object getTop() throws Exception {
        return head.getElement();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
