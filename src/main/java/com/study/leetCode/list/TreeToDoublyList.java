package main.java.com.study.leetCode.list;

/**
 * @author： whb
 * @description： LeetCode-426-二叉搜索树与双向链表
 * @date： 2020-12-02 9:33
 * 难度：中等
 * 标签：分治算法
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class TreeToDoublyList {
    /**
     * pre记录上一个节点，head为最后返回的头结点
     */
    Node pre = null, head = null;

    /**
     * 解题思路：
     * 基于性质：二叉搜索树的中序遍历为 递增序列 。
     * 将 二叉搜索树 转换成一个 “排序的循环双向链表” ，其中包含三个要素：
     *
     * 排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
     * 双向链表： 在构建相邻节点（设前驱节点 pre ，当前节点 cur ）关系时，不仅应 pre.right = cur ，也应 cur.left = pre。
     * 循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = tail 和 tail.right = head。
     *
     * 使用中序遍历访问树的各节点 cur；并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；中序遍历完成后，最后构建头节点和尾节点的引用指向即可。
     *
     * 算法流程：
     * dfs(cur): 递归法中序遍历；
     *
     * 终止条件： 当节点 cur 为空，代表越过叶节点，直接返回；
     * 递归左子树，即 dfs(cur.left) ；
     * 构建链表：
     * 当 pre 为空时： 代表正在访问链表头节点，记为 head 。
     * 当 pre 不为空时： 修改双向节点引用，即 pre.right = curpre.right=cur ， cur.left = precur.left=pre ；
     * 保存 cur ： 更新 pre = curpre=cur ，即节点 cur 是后继节点的 pre ；
     * 递归右子树，即 dfs(cur.left) ；
     * treeToDoublyList(root)：
     *
     * 特例处理： 若节点 root 为空，则直接返回；
     * 初始化： 空节点 pre ；
     * 转化为双向链表： 调用 dfs(root) ；
     * 构建循环链表： 中序遍历完成后，head 指向头节点， pre 指向尾节点，因此修改 head 和 pre 的双向节点引用即可。
     * 返回值： 返回链表的头节点 head 即可。
     *
     *
     * 复杂度分析：
     * 时间复杂度 O(N) ： N 为二叉树的节点数，中序遍历需要访问所有节点。
     * 空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到 N，系统使用 O(N) 栈空间。
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        //边界值
        if (root == null) {
            return null;
        }
        //得到一个双向链表，head指向头结点
        dfs(root);
        //头尾连接，形成双向循环链表
        head.left = pre;
        pre.right = head;
        //返回头节点
        return head;
    }

    private void dfs(Node cur) {
        //递归结束条件
        if (cur == null) {
            return;
        }
        //规整左子树
        dfs(cur.left);
        // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
        if (pre == null) {
            head = cur;
        } else if (pre != null) {
            // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
            // 让上一个节点的右指针指向当前节点
            pre.right = cur;
        }
        // 再让当前节点的左指针指向父节点，也就连成了双向链表
        cur.left = pre;
        // 保存当前节点，用于下层递归创建
        pre = cur;
        //规整右子树
        dfs(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val) {
        this(val, null, null);
    }
}