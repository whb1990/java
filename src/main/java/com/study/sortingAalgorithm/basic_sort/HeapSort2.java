package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2020/3/2 11:01
 * @description: 堆排序方法二
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************堆排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        CommonUtils.display(heapSort(numArr));
    }

    public static int[] heapSort(int[] numArr) {
        int len = numArr.length;
        //构建大顶堆
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(numArr, i, len);
        }
        //堆顶与堆底元素交换
        for (int i = len - 1; i > 0; i--) {
            swap(numArr, 0, i);
            heapify(numArr, 0, i);
        }
        return numArr;
    }

    /**
     * 调整堆
     *
     * @param arr    待排序数组
     * @param parent 根节点
     * @param len    节点数量
     */
    private static void heapify(int[] arr, int parent, int len) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != parent) {
            swap(arr, parent, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
