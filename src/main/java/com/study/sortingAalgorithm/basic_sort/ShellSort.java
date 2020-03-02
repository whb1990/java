package main.java.com.study.sortingAalgorithm.basic_sort;

import main.java.com.study.utils.CommonUtils;

/**
 * @author: whb
 * @date: 2019/6/24 14:14
 * @description: 希尔排序
 */
public class ShellSort {

    /**
     * 希尔排序（Shell’s Sort）又称“缩小增量排序”(Diminishing Increment Sort)，它也是一种属于插入排序类的方法，但在时间效率上比直接插入排序方法有较大的改进。
     * 从对直接插入排序的分析可知，其算法时间复杂度为O(n2)，但是，若待排记录序列为“正序”时，其时间复杂度可提高至O(n)。
     * 由此设想，若待排记录序列按关键字“基本有序”，直接插入排序的效率就可以大大提高。
     * 从另一方面来看，由于直接插入排序算法简单，所以在n值很小时效率比较高。希尔排序正是从这两点分析出发对直接插入排序进行改进而得到的一种插入排序方法。
     * <p>
     * 希尔排序的基本思想是：先将整个待排序列分割成若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行一次直接插入排序。（这是《数据结构》这本书里的说法。）
     * <p>
     * 通俗点说就是：先取较大的步长对待排序列进行直接插入排序，每排一次就缩小一次步长，再进行插入排序，直到最后步长变为1。
     */
    public static void shellSort(int[] numArr) {
        int length = numArr.length;
        //取增量
        int gap = length / 2;
        while (gap >= 1) {
            //无序序列
            for (int i = gap; i < length; i++) {
                int temp = numArr[i];
                int j;
                //有序序列
                for (j = i - gap; j >= 0 && numArr[j] > temp; j = j - gap) {
                    numArr[j + gap] = numArr[j];
                }
                numArr[j + gap] = temp;
            }
            //缩小增量
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        int[] numArr = {27, 11, 13, 45, 34, 22, 19, 8, 3, 99, 74, 55, 88, 66};
        System.out.println("**************希尔排序******************");
        System.out.println("排序前：");
        CommonUtils.display(numArr);
        System.out.println("排序后：");
        shellSort(numArr);
        CommonUtils.display(numArr);
    }
}
