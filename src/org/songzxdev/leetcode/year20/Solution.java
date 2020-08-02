package org.songzxdev.leetcode.year20;

import java.util.*;
import java.util.function.Consumer;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(16);
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int first = nums[0], n = nums.length;
        for (int i = 0; first <= 0 && i < n - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int add = nums[i] + nums[j] + nums[k];
                    if (add == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[++j]) {
                        }
                        while (j < k && nums[k] == nums[--k]) {
                        }
                    } else if (add < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildHelper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorderMap);
    }

    private TreeNode buildHelper(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, Map<Integer, Integer> inorderMap) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int inRoot = inorderMap.get(preorder[preLeft]), leftSubtreeLen = inRoot - 1 - inLeft + 1;
        TreeNode current = new TreeNode(preorder[preLeft]);
        current.left = buildHelper(preLeft + 1, preLeft + leftSubtreeLen, inLeft, inRoot - 1, preorder, inorderMap);
        current.right = buildHelper(preLeft + leftSubtreeLen + 1, preRight, inRoot + 1, inRight, preorder, inorderMap);
        return current;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;
        while (!beginSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            steps++;
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordArray[i] = j;
                        String target = String.valueOf(wordArray);
                        if (endSet.contains(target)) {
                            return steps;
                        }
                        if (wordSet.remove(target)) {
                            nextSet.add(target);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            beginSet = nextSet;
        }
        return 0;
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(n);
        Set<Integer> lie = new HashSet<>(), pie = new HashSet<>(), na = new HashSet<>();
        List<Integer> rows = new ArrayList<>(n);
        dfsNQueens(0, n, lie, pie, na, res, rows);
        return res;
    }

    private void dfsNQueens(int row, int n, Set<Integer> lie, Set<Integer> pie, Set<Integer> na, List<List<String>> res, List<Integer> rows) {
        if (row >= n) {
            res.add(convertBoards(rows, n));
            return;
        }
        for (int l = 0; l < n; l++) {
            if (!(lie.contains(l) || pie.contains(row + l) || na.contains(row - l))) {
                rows.add(l); lie.add(l); pie.add(row + l); na.add(row - l);
                dfsNQueens(row + 1, n, lie, pie, na, res, rows);
                rows.remove(rows.size() - 1); lie.remove(l); pie.remove(row + l); na.remove(row - l);
            }
        }
    }

    private List<String> convertBoards(List<Integer> rows, int n) {
        List<String> boards = new ArrayList<>(n);
        for (int r: rows) {
            char[] board = new char[n];
            for (int i = 0; i < n; i++) {
                board[i] = r == i ? 'Q' : '.';
            }
            boards.add(String.valueOf(board));
        }
        return boards;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
