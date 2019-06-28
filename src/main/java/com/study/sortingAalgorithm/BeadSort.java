package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/28 10:06
 * @description: 珠排序:将每个数用珠子表示，例如：数字5就是5个珠子。用珠子表示好每一个数后，让所有的珠子自由下落。排序完成。
 */
public class BeadSort {

    /**
     * 珠排序
     *
     * @param unsorted 待排序列
     * @return
     */
    public static int[] beadSort(int[] unsorted) {
        //待排序列中的最大值
        int max = 0;
        //获取最大值
        for (int i = 0; i < unsorted.length; i++) {
            if (unsorted[i] > max) {
                max = unsorted[i];
            }
        }
        //每个数都用珠子表示，比如5就用5个珠子，所以用二维数组表示每个数
        char[][] grid = new char[unsorted.length][max];
        int[] levelCount = new int[max];
        for (int i = 0; i < max; i++) {
            levelCount[i] = 0;
            for (int j = 0; j < unsorted.length; j++) {
                grid[j][i] = '_';
            }
        }
        //删除珠子
        for (int i = 0; i < unsorted.length; i++) {
            int num = unsorted[i];
            for (int j = 0; num > 0; j++) {
                grid[levelCount[j]++][j] = '*';
                num--;
            }
        }
        //数珠子，放到已排序列表
        int[] sorted = new int[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            int putt = 0;
            for (int j = 0; j < max && grid[unsorted.length - 1 - i][j] == '*'; j++) {
                putt++;
            }
            sorted[i] = putt;
        }
        return sorted;
    }

    public static void main(String[] args) {
        //产生随机待排序列
        int[] unsorted = new int[(int) (Math.random() * 11) + 5];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * 10);
        }
        System.out.println("**************珠排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        int[] sorted = beadSort(unsorted);
        CommonUtils.display(sorted);
    }
}
