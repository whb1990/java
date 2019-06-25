package main.java.com.study.sortingAalgorithm;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/25 15:53
 * @description: 基数排序：过程无须比较关键字，而是通过“分配”和“收集”过程来实现排序。
 * 平均O(d(n+r)),最好O(d(n+r)),最坏O(d(n+r));空间复杂度O(n+r);稳定;较复杂
 * d为位数,r为分配后链表的个数
 */
public class RadixSort {

    /**
     * 基数排序
     *
     * @param unsorted 待排数组
     * @param max      最大几位数
     */
    public static void radixSort(int[] unsorted, int max) {
        //count数组用来计数
        int[] count = new int[unsorted.length];
        //bucket用来当桶，放数据，取数据
        int[] bucket = new int[unsorted.length];

        //k表示第几位，1代表个位，2代表十位，3代表百位
        for (int k = 1; k <= max; k++) {
            //把count置空，防止上次循环的数据影响
            for (int i = 0; i < unsorted.length; i++) {
                count[i] = 0;
            }

            //分别统计第k位是0,1,2,3,4,5,6,7,8,9的数量
            //以下便称为桶
            //即此循环用来统计每个桶中的数据的数量
            for (int i = 0; i < unsorted.length; i++) {
                count[getFigure(unsorted[i], k)]++;
            }

            //利用count[i]来确定放置数据的位置
            for (int i = 1; i < unsorted.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //执行完此循环之后的count[i]就是第i个桶右边界的位置

            //利用循环把数据装入各个桶中，注意是从后往前装
            for (int i = unsorted.length - 1; i >= 0; i--) {
                int j = getFigure(unsorted[i], k);
                bucket[count[j] - 1] = unsorted[i];
                count[j]--;
            }

            //将桶中的数据取出来，赋值给unsorted
            for (int i = 0, j = 0; i < unsorted.length; i++, j++) {
                unsorted[i] = bucket[j];
            }
        }
    }

    /**
     * 返回整型数num的第pos位是什么
     *
     * @param num 整数num
     * @param pos pos=1表示个位，pos=2表示十位
     * @return
     */
    public static int getFigure(int num, int pos) {
        int tmp = 1;
        for (int i = 0; i < pos - 1; i++) {
            tmp *= 10;
        }
        return (num / tmp) % 10;
    }

    /**
     * 二维数组的方式实现基数排序
     *
     * @param unsorted 待排序列
     * @param arr_x    最大数字不超过999999999...(array_x个9)
     * @param arr_y    最大位数
     */
    public static void radix_sort(int[] unsorted, int arr_x, int arr_y) {
        for (int i = 0; i < arr_x; i++) {
            int[][] bucket = new int[arr_x][arr_y];
            //分配
            for (int item : unsorted) {
                int temp = (item / (int) Math.pow(10, i)) % 10;
                for (int j = 0; j < arr_y; j++) {
                    if (bucket[temp][j] == 0) {
                        bucket[temp][j] = item;
                        break;
                    }
                }
            }
            //收集
            for (int o = 0, x = 0; x < arr_x; x++) {
                for (int y = 0; y < arr_y; y++) {
                    if (bucket[x][y] == 0) {
                        continue;
                    }
                    unsorted[o++] = bucket[x][y];
                }
            }
        }
    }

    public static void main(String[] args) {
        //定义待排整型数组
        int[] arr = {21, 56, 88, 195, 354, 1, 35, 12, 6, 7};
        System.out.println("**************基数排序******************");
        System.out.println("排序前：");
        CommonUtils.display(arr);
        //调用基数排序函数
        radixSort(arr, 3);
        System.out.println("排序后：");
        //输出排序后的数组
        CommonUtils.display(arr);
        System.out.println("   ");
        int[] unsorted = {999999999, 65, 24, 47, 13, 50, 92, 88, 66, 33, 22445, 10001, 624159, 624158, 624155501};
        System.out.println("**************二维数组方式实现的基数排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        radix_sort(unsorted, 10, 100);
        System.out.println("排序后：");
        for (int tmp : unsorted) {
            if (tmp > 0) {
                System.out.print(tmp + "  ");
            }
        }
    }
}
