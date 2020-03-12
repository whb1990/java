package main.java.com.study.list_stack_queue;

/**
 * @author: whb
 * @date: 2020/3/11 19:11
 * @description: 实现动态数组ArrayList
 * 模拟实现ArrayList动态数组，包括的方法如下：
 * rangeCheck()，检查数组下标是否越界；
 * add()，在某个下标位置添加元素；
 * resize()，动态扩容，当数组容量满或者空闲整个数组的3/4时，重新定义数组；
 * get()，获取某个位置的元素值；
 * set()，设置某个下标的元素值；
 * contains()，查找是否包含某个元素；
 * find()，找到某个元素的下标；
 * remove()，移除某个下标对应的值；
 */
public class ArrayList<E> {
    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is Illegal !");
        }
    }

    public void add(int index, E e) {
        rangeCheck(index);
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
            data = newData;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        rangeCheck(index);
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        rangeCheck(index);
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        //防止复杂度的震荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayList ： size = %d，capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
