package org.songzxdev.leetcode.week01;

/**
 * 题号：977.有序数组的平方
 * 标签：数组、双指针
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        // 找出负数的索引
        int n = A.length;
        int j = 0;
        while (j < n && A[j] < 0) {
            j++;
        }
        int i = j - 1;
        int[] ans = new int[n];
        int t = 0;
        while (i >= 0 && j < n) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < n) {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
    }
}
