package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2019/6/28 10:43
 * @description: 计数排序
 */
public class CountingSort {

    public static int[] countingSort(int[] unsorted) {
        //开始声明桶,找到数组的最小值和最大值
        int minNum = unsorted[0];
        int maxNum = unsorted[0];
        for (int i = 0; i < unsorted.length; i++) {
            if (unsorted[i] < minNum) {
                minNum = unsorted[i];
            }
            if (unsorted[i] > maxNum) {
                maxNum = unsorted[i];
            }
        }
        System.out.println("最小数字为:" + minNum);
        System.out.println("最大数字位:" + maxNum);
        //找到最大最小值的之后,就开始声明有序桶,桶的初始位代表的值为minNum最大值为maxNum
        //数组的长度为(maxNum-minNum+1)
        int[] bucket = new int[(maxNum - minNum + 1)];
        //声明了有序桶之后,开始对数字进行放桶操作
        for (int j = 0; j < unsorted.length; j++) {
            //因为是找到了待排序数组的最小值minNum,所以,与数组数组比较的值应为(j+minNum)
            //如果遍历的值大小与数组代表的数字大小相等,则放入
            //j次循环得到的数字是tempArray[j],则存储到下标为tempArray[j]+minNum的桶中
            bucket[unsorted[j] - minNum] = bucket[unsorted[j] - minNum] + 1;
        }
        //将得到的桶排序结果进行输出,输出的是桶排序的数组的下标
        //可以声明新数组对该序列进行存储
        int[] sorted = new int[unsorted.length];
        int count = 0;
        for (int k = 0; k < bucket.length; k++) {
            if (bucket[k] != 0) {
                //桶里装的值可能不是1,所以,在不等于一的时候,对桶里面的数字进行遍历存储
                if (bucket[k] != 1) {
                    for (int z = 0; z < bucket[k]; z++) {
                        sorted[count] = k + minNum;
                        count++;
                    }
                } else {
                    sorted[count] = k + minNum;
                    count++;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        //产生随机待排序列
        int[] unsorted = new int[(int) (Math.random() * 11) + 5];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * 100);
        }
        System.out.println("**************计数排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        int[] sorted = countingSort(unsorted);
        CommonUtils.display(sorted);
    }
}
