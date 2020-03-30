package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:12
 * @description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序的过程很简单，就是不断比较相邻两个元素的大小关系，若逆序则交换，这样通过一轮比较，关键字最大的记录就沉底了。
     * 一般地，第i趟冒泡排序从第一个元素起到第n-i+1个元素依次比较相邻两个记录的关键字，并在逆序时交换相邻记录，其结果就是这n-i+1个记录中关键字最大的记录被交换到n-i+1的位置上。
     * 当然也可以反过来，从后往前进行，这样每经过一趟排序，就把未排序的序列中最小的元素放在它应当处于的位置上，然后下次比较就不再让前面的元素参与了。
     * 整个排序过程需要进行k趟冒泡排序，其中k至少为1，至多为n-1次，如果一趟冒泡排序中没有出现交换元素的操作，则说明序列已经有序了，可以停止排序了。
     * 时间复杂度：正序时O(n)， 逆序时O(n2)，平均时间复杂性O(n2)。使用temp 作为临时交换变量，空间复杂度为 O(1).
     * <p>
     * 一般情况下貌似效率不及直接插入排序（尽管它们的平均时间复杂度都是O(n2)）。
     */
    public static void bubbleSort(int[] numArr) {
        int length = numArr.length;
        //最多length-1次排序
        for (int i = 0; i < length; i++) {
            //每一轮多少元素参与排序
            for (int j = 0; j < length - 1 - i; j++) {
                if (numArr[j] > numArr[j + 1]) {
                    /**
                     * 交换顺序，不使用临时变量，利用
                     * a = a + b;
                     * b = a - b;
                     * a = a - b;
                     */
                    numArr[j] = numArr[j] + numArr[j + 1];
                    numArr[j + 1] = numArr[j] - numArr[j + 1];
                    numArr[j] = numArr[j] - numArr[j + 1];
                }
            }
        }
    }

    /**
     * 改进版冒泡：当某趟排序没有元素交换的时候，证明整个序列有序，无需再循环比较
     *
     * @param numArr
     */
    public static void bubbleSortImprove(int[] numArr) {
        int length = numArr.length;
        //设置标志变量，这样当序列有序时及时退出循环，避免冗余处理。
        boolean sorted = false;
        //最多length-1次排序
        for (int i = 0; i < length; i++) {
            sorted = true;
            //每一轮多少元素参与排序
            for (int j = 0; j < length - 1 - i; j++) {
                if (numArr[j] > numArr[j + 1]) {
                    /**
                     * 交换顺序，不使用临时变量，利用
                     * a = a + b;
                     * b = a - b;
                     * a = a - b;
                     */
                    numArr[j] = numArr[j] + numArr[j + 1];
                    numArr[j + 1] = numArr[j] - numArr[j + 1];
                    numArr[j] = numArr[j] - numArr[j + 1];
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************冒泡排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        bubbleSortImprove(numArr);
        CommonUtils.display(numArr);
    }
}
