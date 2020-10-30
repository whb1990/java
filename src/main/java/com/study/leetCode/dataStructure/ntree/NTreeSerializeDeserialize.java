package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-428-序列化和反序列化N叉树
 * @date： 2020-10-30 17:26
 * 难度：困难
 * 标签：N叉树
 * 序列化是指将一个数据结构转化为位序列的过程，因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
 *
 * 设计一个序列化和反序列化 N 叉树的算法。
 * 一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。
 * 序列化 / 反序列化算法的算法实现没有限制。
 * 你只需要保证 N 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
 *
 * 例如，你需要序列化下面的 3-叉 树。
 *
 * 为 [1 [3[5 6] 2 4]]。你不需要以这种形式完成，你可以自己创造和实现不同的方法。
 *
 * 注意：
 * N 的范围在 [1, 1000]
 * 不要使用类成员 / 全局变量 / 静态变量来存储状态。
 * 你的序列化和反序列化算法应是无状态的。
 */
public class NTreeSerializeDeserialize {
    /**
     * 将一个Node序列化为"parent[child_1,child_2...child_n]"的形式
     *
     * @param root
     * @return
     */
    public String serialize(Node root) {
        //边界
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        // 将parent加入
        res.append(root.val);
        if (root.children == null) {
            return res.toString();
        }
        // 将children都加入，children的两侧用[]包裹
        res.append("[");
        for (Node child : root.children) {
            // 重新利用serialize()函数的含义，把每一个child Node都序列化即可
            res.append(serialize(child));
            res.append(",");
        }
        //删除多余的,
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    /**
     * 将一个形为"parent[child_1,child_2...child_n]"的字符串反序列化为Node
     *
     * @param data
     * @return
     */
    public Node deserialize(String data) {
        //边界
        if (data.isEmpty()) {
            return null;
        }
        //找到parent
        int idx = data.indexOf("[");
        //如果没有children则直接返回
        if (idx == -1) {
            return new Node(Integer.parseInt(data), new ArrayList<>());
        }
        //如果有children
        String val = data.substring(0, data.indexOf("["));
        Node root = new Node(Integer.parseInt(val), new ArrayList<>());
        //解析紧跟着parent的[]中的字符串，将其分为一个个代表child的字符串
        List<String> cData = parse(data.substring(idx + 1, data.length() - 1));
        for (String c : cData) {
            //重新利用deserialize()函数的含义，把每一个child的字符串都反序列再加入parent的children中即可
            root.children.add(deserialize(c));
        }
        return root;
    }

    /**
     * 解析形为"child_1,child_2...child_n"的字符串
     * 将其分为多个字符串，分别代表child_1,child_2...child_n
     *
     * @param data
     * @return
     */
    private List<String> parse(String data) {
        List<String> res = new ArrayList<>();
        int leftBracket = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (c == '[') {
                leftBracket++;
            } else if (c == ']') {
                leftBracket--;
            } else if (c == ',') {
                if (leftBracket == 0) {
                    res.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }
            }
            sb.append(c);
        }
        res.add(sb.toString());
        return res;
    }
}
