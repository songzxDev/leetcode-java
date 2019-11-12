package org.songzxdev.leetcode.week03;

/**
 * 题目：11.盛最多水的容器
 * 标签：数组 双指针
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            ans = Math.max(ans, minHeight * (right - left + 1));
        }
        return ans;
    }
}
