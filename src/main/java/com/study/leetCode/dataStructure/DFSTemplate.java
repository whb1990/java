package main.java.com.study.leetCode.dataStructure;

import java.util.Set;
import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/5/29 11:24
 * @description: 深度优先搜索模版
 * 深度遍历：
 * 第一步：明确递归参数；
 * 第二步：明确递归终止条件；
 * 第三步：明确递归函数中的内容；
 * 第四步：明确回溯返回值。
 */
public class DFSTemplate {
    /**
     * DFS模版一：递归（使用系统栈）
     * 递归解决方案的优点是它更容易实现。 但是，存在一个很大的缺点：如果递归的深度太高，你将遭受堆栈溢出。
     *
     * @param cur
     * @param target
     * @param visited
     * @return
     */
    boolean DFS(CloneGraph.Node cur, CloneGraph.Node target, Set<CloneGraph.Node> visited) {
        //return true if cur is target;
        //for (next : each neighbor of cur) {
        //if (next is not in visited) {
        //add next to visted;
        // return true if DFS(next, target, visited) == true;
        //}
        //}
        return false;
    }

    /**
     * DFS模版二-使用显式栈
     *
     * @param root
     * @param target
     * @return
     */
    boolean DFS2(int root, int target) {
        Set<CloneGraph.Node> visited;
        Stack<CloneGraph.Node> s = new Stack<>();
        // add root to s
        while (!s.isEmpty()) {
            //Node cur = the top element in s;
            //return true if cur is target;
            //for(Node cur : the neighbors of cur){
            //if(next is not in visited){
            //add next to s;
            //add next to visited;
            //}
            //}
            //remove cur from s;
        }
        return false;
    }
}
