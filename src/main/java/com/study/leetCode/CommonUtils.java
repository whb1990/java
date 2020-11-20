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
        StringBuffer buffer = new StringBuffer("[\n");
        for (int i = 0; i < arr.length; i++) {
            buffer.append("    [");
            for (int j = 0; j < arr[i].length; j++) {
                buffer.append(arr[i][j]);
                if (j != arr[i].length - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append("]");
            if (i != arr.length - 1) {
                buffer.append(",\n");
            }
        }
        buffer.append("\n]");
        System.out.println(buffer.toString());
    }

    /**
     * 输出二维字符数组
     *
     * @param arr
     */
    public static void printChar2Arr(char[][] arr) {
        StringBuffer buffer = new StringBuffer("[\n");
        for (int i = 0; i < arr.length; i++) {
            buffer.append("    [");
            for (int j = 0; j < arr[i].length; j++) {
                buffer.append(arr[i][j]);
                if (j != arr[i].length - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append("]");
            if (i != arr.length - 1) {
                buffer.append(",\n");
            }
        }
        buffer.append("\n]");
        System.out.println(buffer.toString());
    }
}
