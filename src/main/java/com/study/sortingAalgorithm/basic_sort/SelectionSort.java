package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:14
 * @description: 选择排序
 */
public class SelectionSort {

    /**
     * 选择排序：每一趟在剩余未排序的若干记录中选取关键字最小的（也可以是最大的）记录作为有序序列中下一个记录。
     * 如第i趟选择排序就是在n-i+1个记录中选取关键字最小的记录作为有序序列中第i个记录。
     * 这样，整个序列共需要n-1趟排序。
     */
    public static void selctionSort(int[] numArr) {
        int length = numArr.length;
        //要遍历的次数（length-1）
        for (int i = 0; i < length - 1; i++) {
            //将当前下标定义为最小值下标
            int min = i;
            //遍历min之后的数据
            for (int j = i + 1; j < length - 1; j++) {
                //如果有小于当前最小值的元素，将它的下标赋值给min
                if (numArr[j] < numArr[min]) {
                    min = j;
                }
            }
            //如果min不等于i，则说明找到了真正的最小值
            if (min != i) {
                swap(numArr, min, i);
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param numArr
     * @param min
     * @param i
     */
    public static void swap(int[] numArr, int min, int i) {
        int temp = numArr[min];
        numArr[min] = numArr[i];
        numArr[i] = temp;
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************选择排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        selctionSort(numArr);
        CommonUtils.display(numArr);
    }
}
