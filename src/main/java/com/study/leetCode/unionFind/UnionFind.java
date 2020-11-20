package main.java.com.study.leetCode.unionFind;

/**
 * @author： whb
 * @description： 并查集对象
 * @date： 2020-11-20 15:16
 */
public class UnionFind {
    /**
     * 记录连通分量
     */
    private int count;

    /**
     * 节点 x 的节点是 parent[x]，存储树
     */
    private int[] parent;

    /**
     * 记录树的"重量"
     */
    private int[] size;

    /**
     * 构造函数，n 为图的节点总数
     *
     * @param n
     */
    public UnionFind(int n) {
        //一开始互不连通
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            //父节点指针初始指向自己
            parent[i] = i;
            // 最初每棵树只有一个节点，重量应该初始化 1
            size[i] = 1;
        }
    }

    /**
     * 连通两个分量
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        //查找根节点
        int rootP = find(p);
        int rootQ = find(q);
        //根节点相等说明已经连通
        if (rootP == rootQ) {
            return;
        }
        // 将两棵树合并为一棵，小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断是否连通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回某个节点 x 的根节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        // 进行路径压缩
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 返回当前的连通分量个数
     *
     * @return
     */
    public int count() {
        return count;
    }
}
