package main.java.com.study.leetCode.dataStructure;

import main.java.com.study.dataStructure.stack.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: whb
 * @date: 2020/5/28 17:56
 * @description: 广度优先搜索模版
 */
public class BFSTemplate {
    /**
     * 在每一轮中，队列中的结点是等待处理的结点。
     * 在每个更外一层的 while 循环之后，我们距离根结点更远一步。变量 step 指示从根结点到我们正在访问的当前结点的距离。
     *
     * @param root
     * @param target
     * @return
     */
    int BFS(Node root, Node target) {
        // store all nodes which are waiting to be processed
        Queue<Node> queue = new LinkedList<>();
        // number of steps neeeded from root to current node
        int step = 0;
        // initialize
        //add root to queue;
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                //Node cur = the first node in queue;
                //return step if cur is target;
                //for (Node next : the neighbors of cur){
                //add next to queue;
                //}
                //remove the first node from queue;
            }
        }
        // there is no path from root to target
        return -1;
    }

    /**
     * 有时，确保永远不会访问一个结点两次很重要。否则，可能陷入无限循环。如果是这样，可以在上面的代码中添加一个哈希集来解决这个问题。
     *
     * @param root
     * @param target
     * @return
     */
    int BFS2(Node root, Node target) {
        // store all nodes which are waiting to be processed
        Queue<Node> queue = new LinkedList<>();
        // store all the used nodes
        Set<Node> used;
        // number of steps neeeded from root to current node
        int step = 0;
        // initialize
        //add root to queue;
        //add root to used;
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                //Node cur = the first node in queue;
                //return step if cur is target;
                //for (Node next : the neighbors of cur) {
                //if (next is not in used) {
                //add next to queue;
                //add next to used;
                // }
                // }
                //remove the first node from queue;
            }
        }
        // there is no path from root to target
        return -1;
    }
}
