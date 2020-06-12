package org.songzxdev.leetcode.study.week02;

import java.util.*;

/**
 * Definition for a binary tree node.
 */

class Solution {

    /**
     * 105.从前序和中序遍历序列构建二叉树
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildHelper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorderMap);
    }

    private TreeNode buildHelper(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, Map<Integer, Integer> inorderMap) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int inRootIdx = inorderMap.get(preorder[preLeft]), leftSubtreeLen = inRootIdx - 1 - inLeft + 1;
        TreeNode curRoot = new TreeNode(preorder[preLeft]);
        curRoot.left = buildHelper(preLeft + 1, preLeft + leftSubtreeLen, inLeft, inRootIdx - 1, preorder, inorderMap);
        curRoot.right = buildHelper(preLeft + leftSubtreeLen + 1, preRight, inRootIdx + 1, inRight, preorder, inorderMap);
        return curRoot;
    }

    /**
     * 127.单次接龙
     * https://leetcode-cn.com/problems/word-ladder/description/
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>();
        int steps = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> nextSet = new HashSet<>();
            steps++;
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old != c) {
                            wordArray[i] = c;
                            String target = String.valueOf(wordArray);
                            if (endSet.contains(target)) {
                                return steps;
                            }
                            if (wordSet.remove(target)) {
                                nextSet.add(target);
                            }
                        }
                    }
                    wordArray[i] = old;
                }
            }
            beginSet = nextSet;
        }
        return 0;
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