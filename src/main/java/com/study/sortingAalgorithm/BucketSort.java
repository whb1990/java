package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/25 15:15
 * @description: 桶排序
 */
public class BucketSort {

    /**
     * 是将阵列分到有限数量的桶子里。每个桶子再个别排序（有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序）。
     * 桶排序是鸽巢排序的一种归纳结果。当要被排序的阵列内的数值是均匀分配的时候，桶排序使用线性时间（Θ（n））。
     * 但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。简单来说，就是把数据分组，放在一个个的桶中，然后对每个桶里面的在进行排序。
     */
    public static int[] bucketSort(int[] unsorted, int maxNumber) {
        int[] sorted = new int[maxNumber + 1];
        for (int i = 0; i < unsorted.length; i++) {
            sorted[unsorted[i]] = unsorted[i];
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] unsorted = {99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18};
        int[] sorted = bucketSort(unsorted, 99);
        System.out.println("**************桶排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        for (int tmp : sorted) {
            if (tmp > 0) {
                System.out.print(tmp + "  ");
            }
        }
    }
}
