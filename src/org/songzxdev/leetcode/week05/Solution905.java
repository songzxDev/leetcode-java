package org.songzxdev.leetcode.week05;

//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
// 你可以返回满足此条件的任何数组作为答案。
// 示例：
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 提示：
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
// Related Topics 数组

public class Solution905 {
    /**
     * 题目：905.按奇偶排序数组
     * 标签：数组 双指针
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int oddSize = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                oddSize++;
            } else if (oddSize > 0) {
                int tmp = A[i - oddSize];
                A[i - oddSize] = A[i];
                A[i] = tmp;
            }
        }
        return A;
    }
}
