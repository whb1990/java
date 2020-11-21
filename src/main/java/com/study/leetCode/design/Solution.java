package main.java.com.study.leetCode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author： whb
 * @description： LeetCode-710-黑名单中的随机数
 * @date： 2020-11-21 16:07
 * 难度：困难
 * 标签：排序、哈希表、二分查找、随机、设计
 * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
 *
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 *
 * 提示:
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) 不包含 N，详细参见 interval notation 。
 *
 * 示例 1:
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出: [null,0,0,0]
 *
 * 示例 2:
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出: [null,1,1,1]
 *
 * 示例 3:
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 *
 * 示例 4:
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出: [null,1,3,1]
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 */
public class Solution {
    //最终数组中的元素个数
    private int size;
    //随机数对象
    private Random random;
    private Map<Integer, Integer> mapping;

    public Solution(int N, int[] blacklist) {
        this.random = new Random();
        this.size = N - blacklist.length;
        this.mapping = new HashMap<>();
        // 先将所有黑名单数字加入 mapping
        for (int b : blacklist) {
            // 这里赋值多少都可以
            // 目的仅仅是把键存进哈希表
            // 方便快速判断数字是否在黑名单内
            mapping.put(b, 666);
        }
        //最后一个元素的索引
        int last = N - 1;
        //将黑名单中的索引换到最后去
        for (int b : blacklist) {
            //如果 b 已经在区间 [size, N),可以直接忽略
            if (b >= size) {
                continue;
            }
            // 跳过所有黑名单中的数字
            while (mapping.containsKey(last)) {
                last--;
            }
            // 将黑名单中的索引映射到合法数字
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        // 随机选取一个索引
        int index = random.nextInt(size);
        // 这个索引命中了黑名单，需要被映射到其他位置
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        // 若没命中黑名单，则直接返回
        return index;
    }

    public static void main(String[] args) {
        System.out.println("====示例1==========");
        Solution solution = new Solution(1, new int[]{});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println("====示例2==========");
        solution = new Solution(2, new int[]{});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println("====示例3==========");
        solution = new Solution(3, new int[]{1});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println("====示例4==========");
        solution = new Solution(4, new int[]{2});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }
}
