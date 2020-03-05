package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:13
 * @description: 快速排序
 */
public class QuickSort {

    /**
     * 快速排序的基本思想是，通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比另一部分记录的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * <p>
     * 一趟快速排序（或一次划分）的过程如下：首先任意选取一个记录（通常可选第一个记录）作为枢轴（或支点）（pivot），然后按下列原则重新排列其余记录：将所有关键字比它小的记录都安置在它的位置之前，将所有关键字比它大的记录都安置在它的位置之后。
     * <p>
     * 经过一趟快速排序之后，以该枢轴记录最后所落的位置i作分界线，将序列分割成两个子序列，之后再分别对分割所得的两个子序列进行快速排序。
     * <p>
     * 可以看出这个算法可以递归实现，可以用一个函数来实现划分，并返回分界位置。然后不断地这么分下去直到排序完成，可以看出函数的输入参数需要提供序列的首尾位置。
     */
    public static void quickSort(int[] numArr, int left, int right) {
        //不管使用哪种分割方式，都可以通过递归形式进行排序
        // 需要注意的是这个if语句不能少，不然没法停止，会导致堆栈溢出的异常。
        if (left < right) {
            //分割数组，找到分割点
            int point = partitionFour(numArr, left, right);
            //递归调用，对左子数组进行快速排序
            quickSort(numArr, left, point - 1);
            //递归调用，对右子数组进行快速排序
            quickSort(numArr, point + 1, right);
        }
    }

    /**
     * 划分实现1 （枢轴跳来跳去法）
     * 一趟快速排序的实现：设两个指针left和right，设枢轴记录的关键字为first，则首先从right所指位置起向前搜索找到第一个关键字小于first的记录和枢轴记录互相交换，
     * 然后从left所指位置起向后搜索，找到第一个关键字大于first的记录和枢轴记录互相交换，重复这两步直至left==right为止。
     */
    public static int partitionOne(int[] numArr, int left, int right) {
        //用数组的第一个元素做基准元素
        int first = numArr[left];
        while (left < right) {
            while (left < right && numArr[right] >= first) {
                right--;
            }
            //交换
            swap(numArr, left, right);
            while (left < right && numArr[left] <= first) {
                left++;
            }
            //交换
            swap(numArr, left, right);
        }
        //返回分割点所在的位置
        return left;
    }

    /**
     * 划分实现2 （枢轴一次到位法）
     * partitionOne实现可以看出，枢轴元素（即最开始选的“中间”元素（其实往往是拿第一个元素作为“中间”元素））需要不断地和其他元素交换位置，而每交换一次位置实际上需要三次赋值操作。
     * <p>
     * 实际上，只有最后left=right的位置才是枢轴元素的最终位置，所以可以先将枢轴元素保存起来，排序过程中只作元素的单向移动，直至一趟排序结束后再将枢轴元素移至正确的位置上。
     *
     * @return
     */
    public static int partitionTwo(int[] numArr, int left, int right) {
        int first = numArr[left];
        int temp = numArr[left];
        while (left < right) {
            while (left < right && numArr[right] >= first) {
                right--;
            }
            numArr[left] = numArr[right];
            while (left < right && numArr[left] <= first) {
                left++;
            }
            numArr[right] = numArr[left];
        }
        numArr[left] = temp;
        return left;
    }

    /**
     * 最原始的partition写法:
     * 在[L, R]之间，选取arr[L]为划分点key；
     * 然后从[L, R]，如果当前arr[i] < key，就放到左边部分swap(arr, i, ++pivot);，否则就不动；
     * 最后将数组划分成了arr[L...p-1] < arr[p] ， arr[p+1...R] > arr[p]，并返回p；
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partitionThree(int[] arr, int left, int right) {
        //直接选取 arr[L]作为pivot(中心点)
        int key = arr[left];
        int pivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < key) {
                swap(arr, i, ++pivot);
            }
        }
        // 将arr[L]放到pivot位置(中间) --> 完成了按照arr[L]划分数组的目的
        swap(arr, pivot, left);
        return pivot;
    }

    /**
     * 双路快速排序-解决重复元素多的问题
     * 当我们要排序的数组重复元素很多的情况下，还是会使得划分极其的不均匀:
     * 第一个解决的方法: 换一种划分的方式:
     * <p>
     * 将 <key和>key的元素放在数组的两边，更准确的说是: 左端放的是 <=key的元素，右端放的是>=key的元素；
     * 然后设置两个指针(一个从L开始，一个从R开始)，然后向中间靠拢，分别找到第一个>=key(左边)、<=key(右边)的元素，就停止扫描，然后交换这两个位置，终止条件是两个指针相碰；
     * 为什么这样就可以解决重复元素多的问题呢? 因为两个指针的元素相等且都等于key的时候，还是要交换两个位置，这样就不会将重复的元素集中在同一侧。
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int partitionFour(int[] arr, int L, int R) {
        int key = arr[L];
        int less = L + 1, more = R;
        while (true) {
            while (less < R && arr[less] < key) {
                less++;
            }
            while (more > L && arr[more] > key) {
                more--;
            }
            if (less >= more) {
                break;
            }
            swap(arr, less++, more--);
        }
        swap(arr, L, more);
        return more;
    }

    /**
     * 三路快速排序--更好的解决重复元素多的问题。三路快排关键在于partion的过程(荷兰国旗问题)，也就是将一个数组按照某个数划分成三部分:
     * <p>
     * 先从序列中选取一个数作为基数(key)；
     * 分区过程，将<key放到左边，>key的放在右边，=key放到中间；
     * 再对左右区间重复第二步，直到各区间只有一个数；
     * 返回的p数组中p[0]代表的是等于区域的左边界，p[1]代表的是等于区域的右边界；
     *
     * @param arr
     * @param left
     * @param right
     * @param num
     * @return
     */
    public static int[] partitionFive(int[] arr, int left, int right, int num) {
        //小于部分的最后一个数
        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < num) {
                //把这个比num小的数放到小于区域的下一个，并且把小于区域扩大一个单位
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                //把这个比num大的数放到大于区域的下一个，并且把大于区域扩大一个单位
                //同时，因为从大于区域拿过来的数是未知的，所以不能cur++，还要再次判断一次arr[cur]
                swap(arr, --more, cur);
            } else {
                //否则的话就直接移动
                cur++;
            }
        }
        //返回的是等于区域的两个下标
        return new int[]{less + 1, more - 1};
    }

    /**
     * 交换数组中两个位置的元素
     */
    private static void swap(int[] numArr, int left, int right) {
        int temp = 0;
        if (numArr != null && numArr.length > 0) {
            temp = numArr[left];
            numArr[left] = numArr[right];
            numArr[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************快速排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        quickSort(numArr, 0, numArr.length - 1);
        CommonUtils.display(numArr);
    }
}
