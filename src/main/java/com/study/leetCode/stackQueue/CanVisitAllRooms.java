package main.java.com.study.leetCode.stackQueue;

import java.util.*;

/**
 * @author: whb
 * @date: 2020/5/29 18:07
 * @description: LeetCode-841-钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms0 = new ArrayList<>();
        List<Integer> room00 = new ArrayList<>();
        room00.add(1);
        List<Integer> room01 = new ArrayList<>();
        room01.add(2);
        List<Integer> room02 = new ArrayList<>();
        room02.add(3);
        List<Integer> room03 = new ArrayList<>();

        rooms0.add(room00);
        rooms0.add(room01);
        rooms0.add(room02);
        rooms0.add(room03);
        System.out.println(canVisitRooms(rooms0));

        // [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms1 = new ArrayList<>();
        List<Integer> room10 = new ArrayList<>();
        room10.add(1);
        room10.add(3);
        List<Integer> room11 = new ArrayList<>();
        room11.add(3);
        room11.add(0);
        room11.add(1);
        List<Integer> room12 = new ArrayList<>();
        room12.add(2);
        List<Integer> room13 = new ArrayList<>();
        room13.add(0);
        rooms1.add(room10);
        rooms1.add(room11);
        rooms1.add(room12);
        rooms1.add(room13);
        System.out.println(canVisitRooms(rooms1));

    }

    /**
     * 广度优先搜索（BFS）的方式进行探索。将可访问的0房间加入队列之中，访问队列中的一个元素，遍历他可以到达的房间，
     * 如果该房间还不能被访问，那么设置为访问，否则跳过。
     *
     * @param rooms
     * @return
     */
    public static boolean canVisitRooms(List<List<Integer>> rooms) {
        //用栈来存储下一步将要参观的房间
        Stack<Integer> toVisit = new Stack<>();
        toVisit.add(0);
        //用hashSet存储已经参观过的房间
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!toVisit.isEmpty()) {
            int roomNum = toVisit.pop();
            //如果当前所在的房间里的钥匙，对应的那个房间不在已参观的房间里边
            //那么就将钥匙对应的房间加入到将要参观的房间里，同时也加入到已参观的房间里
            for (Integer keyNum : rooms.get(roomNum)) {
                if (!visited.contains(keyNum)) {
                    toVisit.add(keyNum);
                    visited.add(keyNum);
                    //若所有房间都在已参观的房间集合里，就提前结束
                    if (toVisit.size() == visited.size()) {
                        return true;
                    }
                }
            }
        }
        return rooms.size() == visited.size();
    }
}
