package org.songzxdev.leetcode.homework.week01;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_1034 {

    /**
     * 题目1.两数之和（https://leetcode-cn.com/problems/two-sum/）
     * 学号：1034（五期一班三组）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        return new int[2];
    }
}
