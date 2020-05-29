package main.java.com.study.leetCode.sort.basic_sort;

import main.java.com.study.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/6/26 2:22
 * @description: 耐心排序
 */
public class PatienceSort {
    public static int[] patienceSort(int[] unsorted) {
        List new_list = new ArrayList();
        for (int i = 0; i < unsorted.length; i++) {
            List bucket_list = new ArrayList();
            if (i == 0) {
                bucket_list.add(unsorted[i]);
                new_list.add(bucket_list);
            } else {
                boolean is_ok = false;
                for (int j = 0; j < new_list.size(); j++) {
                    if (unsorted[i] < (int) ((List) new_list.get(j)).get(0)) {
                        ((List) new_list.get(j)).add(0, unsorted[i]);
                        is_ok = true;
                        break;
                    }
                }
                if (!is_ok) {
                    bucket_list.add(unsorted[i]);
                    new_list.add(bucket_list);
                }
            }
        }
        //多维数组变成单维数组
        int[] ok_list = new int[unsorted.length];
        int q = 0;
        for (int m = 0; m < new_list.size(); m++) {
            for (int n = 0; n < ((List) new_list.get(m)).size(); n++) {
                ok_list[q] = (int) ((List) new_list.get(m)).get(n);
                q++;
            }
        }

        //插入循环
        //将数组的长度赋给n是为了防止每次for循环中判断时都调用length方法影响性能
        int n = ok_list.length;
        //用于中转数据
        int tmp;
        int j;
        //排序的次数
        for (int i = 1; i < n; i++) {
            tmp = ok_list[i];
            //取i前面的所有跟i位置元素进行比较，先比较i-1和i，如果i-1大于i，则互换位置，i-1和i-2比较，以此类推
            for (j = i - 1; j >= 0 && ok_list[j] > tmp; j--) {
                ok_list[j + 1] = ok_list[j];
            }
            ok_list[j + 1] = tmp;
        }
        return ok_list;
    }

    public static void main(String[] args) {
        int[] unsorted = {6, 4, 5, 1, 8, 7, 2, 3};
        System.out.println("**************耐心排序******************");
        System.out.println("排序前：");
        CommonUtils.display(unsorted);
        System.out.println("排序后：");
        int[] sorted = patienceSort(unsorted);
        CommonUtils.display(sorted);
    }
}
