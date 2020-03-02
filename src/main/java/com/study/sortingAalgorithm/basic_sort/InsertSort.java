package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:12
 * @description: 插入排序
 */
public class InsertSort {
    /**
     * 直接插入排序是一种最简单的排序方法，它的基本操作是将一个记录插入到已排好的有序的表中，从而得到一个新的、记录数增1的有序表。
     * <p>
     * 当前元素的前面元素均为有序，要插入时，从当前元素的左边开始往前找（从后往前找），比当前元素大的元素均往右移一个位置，最后把当前元素放在它应该呆的位置就行了。
     * 移动、比较的次数可作为衡量时间复杂性的标准。
     * <p>
     * 　　最优情况：如果原始的输入序列为正序：
     * <p>
     * 　　比较次数：n-1
     * <p>
     * 　　移动次数：0
     * <p>
     * 　　最差情况：如果原始的输入序列为逆序：
     * <p>
     * 　　比较次数：(n+2)(n-1)/2
     * <p>
     * 　　移动次数：(n+4)(n-1)/2
     * <p>
     * 　　所以直接插入排序的时间复杂度为O(n2)。
     */

    public static void insertSort(int[] numArr) {
        int length = numArr.length;
        for (int i = 1; i < length; i++) {
            int temp = numArr[i];
            int j;
            //遍历有序序列，如果有序序列中的元素比临时元素大，则将有序序列中比临时元素大的元素依次向后移动
            for (j = i - 1; j >= 0 && numArr[j] > temp; j--) {
                numArr[j + 1] = numArr[j];
            }
            //将临时元素插入到腾出的位置
            numArr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************直接插入排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        insertSort(numArr);
        CommonUtils.display(numArr);
    }
}
