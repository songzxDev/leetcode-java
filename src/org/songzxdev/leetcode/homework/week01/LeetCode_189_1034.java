package org.songzxdev.leetcode.homework.week01;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]
// 向右旋转 4 步: [4,5,6,7,1,2,3]
// 向右旋转 5 步: [3,4,5,6,7,1,2]
// 向右旋转 6 步: [2,3,4,5,6,7,1]
// 向右旋转 7 步: [1,2,3,4,5,6,7]
//
//  示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组

import java.util.Arrays;

public class LeetCode_189_1034 {
    /**
     * 题目：189.旋转数组（https://leetcode-cn.com/problems/rotate-array/）
     * 学号：1034（五期一班三组）
     * 空间复杂度为O(1)的原地算法
     * 时间复杂度为：O(2n)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k > 0) {
            reverse(0, nums.length - 1, nums);
            reverse(0, k - 1, nums);
            reverse(k, nums.length - 1, nums);
        }
    }

    private void reverse(int begin, int end, int[] nums) {
        while (begin < end) {
            int tmp = nums[end];
            nums[end--] = nums[begin];
            nums[begin++] = tmp;
        }
    }

    /**
     * 题目：189.旋转数组（https://leetcode-cn.com/problems/rotate-array/）
     * 学号：1034（五期一班三组）
     * 空间复杂度为O(1)的原地算法
     * 时间复杂度为：O(n * k)
     *
     * @param nums
     * @param k
     */
    public void rotateSlow(int[] nums, int k) {
        // 输入: [1,2,3,4,5,6,7] 和 k = 3
        // 向右旋转 1 步: [7,1,2,3,4,5,6]
        // 向右旋转 2 步: [6,7,1,2,3,4,5]
        // 向右旋转 3 步: [5,6,7,1,2,3,4]
        // 向右旋转 4 步: [4,5,6,7,1,2,3]
        // 向右旋转 5 步: [3,4,5,6,7,1,2]
        // 向右旋转 6 步: [2,3,4,5,6,7,1]
        // 向右旋转 7 步: [1,2,3,4,5,6,7]
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int outer = nums.length - 1, last = nums[nums.length - 1];
            while (outer > i) {
                nums[outer] = nums[--outer];
            }
            nums[i] = last;
        }
        int j = -1, p = k / 2;
        while (k > 0 && ++j < p) {
            int tmp = nums[--k];
            nums[k] = nums[j];
            nums[j] = tmp;
        }
        // System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        LeetCode_189_1034 l = new LeetCode_189_1034();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        // [5,6,7,1,2,3,4]
        l.rotateSlow(nums, 3);
    }
}
