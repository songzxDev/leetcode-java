package org.songzxdev.leetcode.study.week01;

public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        k %= n;
        if (k > 0) {
            rotateHelper(nums, 0, n - 1);
            rotateHelper(nums, 0, k - 1);
            rotateHelper(nums, k, n - 1);
        }

    }

    private void rotateHelper(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
