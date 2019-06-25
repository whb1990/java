package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/25 19:59
 * @description: 鸽巢排序
 * 原理类似桶排序,同样需要一个很大的鸽巢[桶排序里管这个叫桶,名字无所谓]
 * 鸽巢其实就是数组,数组的索引位置就表示值,该索引位置的值表示出现次数,如果全部为1次或0次那就是桶排序
 * 例如
 * int[] pigeonHole = new int[100];
 * pigeonHole[0]的值表示0的出现次数...
 * pigeonHole[1]的值表示1的出现次数...
 * pigeonHole[2]的值表示2的出现次数...
 */
public class PigeonholeSort {

    /**
     * 鸽巢排序
     *
     * @param unsorted  待排序列
     * @param maxNumber 最大数
     * @return
     */
    public static int[] pigeonholeSort(int[] unsorted, int maxNumber) {
        int[] pogeonHole = new int[maxNumber + 1];
        for (int item : unsorted) {
            pogeonHole[item]++;
        }
        return pogeonHole;
    }

    public static void main(String[] args) {
        int[] unsorted = {99, 65, 24, 47, 47, 50, 99, 88, 66, 33, 66, 67, 31, 18, 24};
        System.out.println("**************鸽巢排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        int[] sorted = pigeonholeSort(unsorted, 99);
        System.out.println("排序后：");
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted[i]; j++) {
                System.out.print(i + "  ");
            }
        }
    }
}
