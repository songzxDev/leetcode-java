package org.songzxdev.leetcode.study.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */

class Solution {

    /**
     * 105.从前序和中序遍历序列构建二叉树
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}