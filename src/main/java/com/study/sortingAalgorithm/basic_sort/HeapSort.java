package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:12
 * @description: 堆排序
 */
public class HeapSort {

    /**
     * 堆排序的是集合了插入排序的单数组操作，又有归并排序的时间复杂度，完美的结合了2者的优点。
     */
    public static void heapSort(int[] numArr) {
        //将无序堆构造成一个大根堆，大根堆有length/2个父节点
        for (int i = numArr.length / 2 - 1; i >= 0; i--) {
            headAdjust(numArr, i, numArr.length);
        }
        //逐步将每个最大值的根节点与末尾元素交换，并且再调整其为最大堆
        for (int i = numArr.length - 1; i > 0; i--) {
            //将堆顶元素和当前未经排序的子序列的最后一个元素交换位置
            swap(numArr, 0, i);
            headAdjust(numArr, 0, i);
        }
    }

    /**
     * 构造大根堆
     */
    public static void headAdjust(int[] numArr, int parent, int length) {
        //保存当前父节点
        int temp = numArr[parent];
        //得到左孩子
        int leftChild = 2 * parent + 1;
        while (leftChild < length) {
            //如果parent有左孩子，则要判断左孩子是否小于右孩子
            if (leftChild + 1 < length && numArr[leftChild] < numArr[leftChild + 1]) {
                leftChild++;
            }
            //如果父节点大于子节点，就不交换
            if (temp >= numArr[leftChild]) {
                break;
            }
            //将较大子节点的值赋给父节点
            numArr[parent] = numArr[leftChild];
            //然后将子节点作为父节点
            parent = leftChild;
            //找到该父节点较小的左孩子
            leftChild = 2 * parent + 1;
        }
        //最后将temp的值赋给较大的子节点，以形成两值交换
        numArr[parent] = temp;
    }

    /**
     * 交换数组中两个位置的元素
     */
    public static void swap(int[] numArr, int top, int last) {
        int temp = numArr[top];
        numArr[top] = numArr[last];
        numArr[last] = temp;
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************堆排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        heapSort(numArr);
        CommonUtils.display(numArr);
    }
}
