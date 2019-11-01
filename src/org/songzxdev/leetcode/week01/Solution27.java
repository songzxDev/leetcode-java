package org.songzxdev.leetcode.week01;

/**
 * 题号：27.移除元素（数组、双指针、原地算法）
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
