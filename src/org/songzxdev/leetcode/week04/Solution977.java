package org.songzxdev.leetcode.week04;

public class Solution977 {
    /**
     * 题目：977.有序数组的平方
     * 标签：双指针 数组
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int p = j; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[p] = A[i] * A[i++];
            } else {
                res[p] = A[j] * A[j--];
            }
        }
        return res;
    }
}
