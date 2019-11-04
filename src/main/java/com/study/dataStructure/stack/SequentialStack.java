package main.java.com.study.dataStructure.stack;

/**
 * @author: whb
 * @date: 2019/11/4 18:10
 * @description: 顺序栈
 */
public class SequentialStack implements Stack {
    /**
     * 对象数组，顺序栈是用数组实现的
     */
    Object[] stack;
    /**
     * 默认长度
     */
    final int defaultSize = 10;
    /**
     * 栈顶位置（的一个下标）
     */
    int top;
    /**
     * 最大长度
     */
    int maxSize;

    /**
     * 无参构造器：默认长度
     */
    public SequentialStack() {
        init(defaultSize);
    }

    /**
     * 有参构造：最大长度
     *
     * @param size
     */
    public SequentialStack(int size) {
        init(size);
    }

    public void init(int size) {
        this.maxSize = size;
        top = 0;
        stack = new Object[size];
    }

    /**
     * 入栈
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void push(Object obj) throws Exception {
        //首先判断栈是否已满
        if (top == maxSize) {
            throw new Exception("栈已满！");
        }
        stack[top] = obj;
        top++;
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
            throw new Exception("栈空！");
        }
        top--;
        return stack[top];
    }

    /**
     * 获取栈顶元素
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object getTop() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空！");
        }
        return stack[top - 1];
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }
}
