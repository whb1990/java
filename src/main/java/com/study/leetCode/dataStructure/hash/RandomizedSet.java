package main.java.com.study.leetCode.dataStructure.hash;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/6/11 18:06
 * @description: LeetCode-380-常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 * <p>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * <p>
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * <p>
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * <p>
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * <p>
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * <p>
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * <p>
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 */
public class RandomizedSet {
    /**
     * 核心思路是用map记录数组每个值对应的下标，在插入和删除时不需要遍历数组寻找对应的数字下标，从而实现插入O(1)
     * 由于删除数组中的数据不是O(1),这里将数组中待删除的数字用数组最后一个数字代替，然后size - 1,下次insert的时候将size位置的数字覆盖，从而实现O(1)删除
     **/
    /**
     * 使用Map保存元素和对应的index，这道题要注意，不允许重复元素
     */
    private Map<Integer, Integer> map;
    /**
     * 使用List保存元素
     */
    private List<Integer> list;
    /**
     * size记录元素个数
     */
    private int size;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        //这里需要用add(index,value)的重载方法，覆盖当前的size位置,这个方法在size == index也可以使用
        //不能使用set(index,value)方法，这个方法会在size == index时直接抛异常
        list.add(size, val);
        map.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (size == 0) {
            map.remove(val);
        } else {
            int oldIndex = map.get(val);
            int lastVal = list.get(size - 1);
            list.set(oldIndex, lastVal);
            map.put(lastVal, oldIndex);
            map.remove(val);
            size--;
        }
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }
}
