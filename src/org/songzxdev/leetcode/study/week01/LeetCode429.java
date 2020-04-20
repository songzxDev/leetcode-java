package org.songzxdev.leetcode.study.week01;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new ArrayList<>(16);
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>(16);
            final int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                currList.add(curr.val);
                queue.addAll(curr.children);
            }
            res.add(currList);
        }
        return res;
    }


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};
