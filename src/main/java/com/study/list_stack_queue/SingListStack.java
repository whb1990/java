package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/12 16:58
 * @description: 单向链表实现栈
 */
public class SingListStack<E> {

    private SingleLinkedList<E> list;

    public SingListStack() {
        this.list = new SingleLinkedList<>();
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        SingListStack<Integer> stack = new SingListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
    }
}
