package main.java.com.study.leetCode;

/**
 * @author： whb
 * @description：
 * @date： 2020-11-17 8:47
 */
public class CommonUtils {
    /**
     * 输出int二维数组
     *
     * @param arr
     */
    public static void printInt2Arr(int[][] arr) {
        StringBuffer buffer = new StringBuffer("[");
        for (int i = 0; i < arr.length; i++) {
            buffer.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                buffer.append(arr[i][j]);
                if (j != arr[i].length - 1) {
                    buffer.append(",");
                }
            }
            buffer.append("]");
            if (i != arr.length - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        System.out.println(buffer.toString());
    }
}
