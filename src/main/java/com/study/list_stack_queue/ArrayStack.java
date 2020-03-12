package main.java.com.study.list_stack_queue;


/**
 * @author: whb
 * @date: 2020/3/12 16:44
 * @description: 使用Array动态数组和链表实现栈
 */
public class ArrayStack<E> {

    private ArrayList<E> array;

    public ArrayStack(int capacity) {
        array = new ArrayList<>(capacity);
    }

    public ArrayStack() {
        array = new ArrayList<>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());
    }
}
