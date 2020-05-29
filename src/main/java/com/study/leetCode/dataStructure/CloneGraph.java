package main.java.com.study.leetCode.dataStructure;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/5/29 11:39
 * @description: LeetCode-克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * 示例 1：
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * 示例 2：
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * <p>
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * <p>
 * 示例 4：
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 */
public class CloneGraph {
    /**
     * BFS解法
     * 使用一个hashmap保存所有遇到的节点，借助一个队列linkedlist来实现层序遍历。
     * 以示例1为例，对于层序遍历来说，我们是先遍历
     * 第一层：第一个节点1，
     * 第二层：再去遍历与1相连的两个节点3、4
     * 第三层：遍历最后一个与3、4相连的节点2
     *
     * @param node
     * @return
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        //定义map，key为已有节点，value为克隆节点
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> list = new LinkedList<>();
        //克隆给定的节点
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        list.add(node);
        while (!list.isEmpty()) {
            Node tmp = list.remove();
            //遍历邻居节点
            for (Node n : tmp.neighbors) {
                if (!map.containsKey(n)) {
                    Node next = new Node(n.val, new ArrayList<>());
                    map.put(n, next);
                    list.add(n);
                }
                //给克隆节点的邻居赋值
                map.get(tmp).neighbors.add(map.get(n));
            }
        }
        return clone;
    }

    /**
     * DFS解法
     * 对于深度遍历来说，依旧需要一个map保存已经创建过的node节点。每一层需要先判断map中是否已经有这个node，
     * 有的话就可以直接返回这个node的clone节点，不然需要创建clone节点返回。DFS用到递归，这里递归的结束条件
     * 应该就是每个节点的neighbors列表遍历完毕，所以当完成遍历neighbors就返回，返回值就是复制的node节点。
     *
     * @param node
     * @return
     */
    Map<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, clone);
        for (Node n : node.neighbors) {
            Node tmp = dfs(n);
            clone.neighbors.add(tmp);
        }
        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
