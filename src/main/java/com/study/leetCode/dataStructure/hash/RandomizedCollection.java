package main.java.com.study.leetCode.dataStructure.hash;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/6/11 18:57
 * @description: LeetCode-381-O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 * <p>
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * <p>
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * <p>
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * <p>
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 */
public class RandomizedCollection {
    /**
     * Map存储每个元素在List中的下标
     */
    private Map<Integer, Set<Integer>> map;
    /**
     * List存储所有元素值
     */
    private List<Integer> list;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
        this.size = 0;
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            Set<Integer> indexs = map.get(val);
            list.add(size, val);
            indexs.add(size);
            size++;
            return false;
        }
        Set<Integer> indexs = new HashSet<>();
        map.put(val, indexs);
        list.add(size, val);
        indexs.add(size);
        size++;
        return true;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //获取待删除元素的所有下标
        Set<Integer> indexs = map.get(val);
        //获取数组的最后一个元素
        int lastVal = list.get(size - 1);
        //如果数组的最后一个元素等于待删除元素
        if (lastVal == val) {
            //直接从待删除元素下标中移除最后一个元素的下标
            indexs.remove(size - 1);
            size--;
        } else {
            //获取待删除元素的某个下标
            Iterator<Integer> iterator = indexs.iterator();
            int index = iterator.next();
            //删除下标
            iterator.remove();
            //把list的最后一个值放到对应下标那
            list.set(index, lastVal);
            //获取最后一个元素的所有下标
            Set<Integer> lastIndexs = map.get(lastVal);
            //移除最后一个下标
            lastIndexs.remove(size - 1);
            //将当前下标添加进来
            lastIndexs.add(index);
            size--;
        }
        //如果元素无任何下标，则直接从map中移除该元素
        if (indexs.size() == 0) {
            map.remove(val);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }
}
