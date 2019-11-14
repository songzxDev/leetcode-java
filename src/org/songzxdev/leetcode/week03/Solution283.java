package org.songzxdev.leetcode.week03;

/**
 * 题目：283.移动零
 * 标签：数组 双指针
 * 将连续排列的元素 0 视为一个雪球，后面非 0 元素，则和最前面的为0元素索引进行交换
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        // 定义雪球大小
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int tmp = nums[i];
                // 将连续排列的元素 0 视为一个雪球，后面非 0 元素，则和最前面的为0元素索引进行交换
                nums[i - snowBallSize] = tmp;
                nums[i] = 0;
            }
        }
    }
}
