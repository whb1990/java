package main.java.com.study.sortingAalgorithm;

/**
 * @author: whb
 * @date: 2019/6/25 10:03
 * @description: 排序算法比较
 */
public class SortingAlgorithmVS {

    public static void main(String[] args) {
        testBubbleSort();
        testHeapSort();
        testInsertSort();
        testMergeSort();
        testQuickSort();
        testSelectionSort();
        testShellSort();
    }

    /**
     * 测试冒泡排序
     */
    public static void testBubbleSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试堆排序
     */
    public static void testHeapSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试插入排序
     */
    public static void testInsertSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        InsertSort.insertSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试归并排序
     */
    public static void testMergeSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(numArr, new int[numArr.length], 0, numArr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试快速排序
     */
    public static void testQuickSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(numArr, 0, numArr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试选择排序
     */
    public static void testSelectionSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        SelectionSort.selctionSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("简单选择排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 测试希尔排序
     */
    public static void testShellSort() {
        int[] numArr = getNumArr(10000);
        long startTime = System.currentTimeMillis();
        ShellSort.shellSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 组装数组
     *
     * @param numLength 数组长度
     * @return
     */
    public static int[] getNumArr(int numLength) {
        int[] numArr = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            numArr[i] = (int) (Math.random() * 100000);
        }
        return numArr;
    }
}
