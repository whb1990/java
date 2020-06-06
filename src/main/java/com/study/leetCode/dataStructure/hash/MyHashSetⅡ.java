package main.java.com.study.leetCode.dataStructure.hash;

/**
 * @author: whb
 * @date: 2020/6/6 19:10
 * @description: LeetCode-705-设计哈希集合
 * 使用boolean 数组结构实现
 */
public class MyHashSetⅡ {
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    public MyHashSetⅡ() {
        table = new boolean[buckets][];
    }

    /**
     * 计算哈希值（key对应桶组）
     *
     * @param key
     * @return
     */
    public int hash(int key) {
        return key / buckets;
    }

    /**
     * key对应桶内下标
     *
     * @param key
     * @return
     */
    public int pos(int key) {
        return key % buckets;
    }

    public void add(int key) {
        int hashKey = hash(key);
        if (table[hashKey] == null) {
            table[hashKey] = new boolean[itemsPerBucket];
        }
        table[hashKey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        if (table[hashKey] != null) {
            table[hashKey][pos(key)] = false;
        }
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        return table[hashKey] != null && table[hashKey][pos(key)];
    }

    public static void main(String[] args) {
        MyHashSetⅡ hashSet = new MyHashSetⅡ();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
