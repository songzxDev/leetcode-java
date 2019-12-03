package org.songzxdev.leetcode.week05;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
// 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
// 注意：答案中不可以包含重复的三元组。
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics 数组 双指针

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return res;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sumNum = nums[i] + nums[j] + nums[k];
                    if (sumNum < 0) {
                        while (j < k && nums[j] == nums[++j]) {
                        }
                    } else if (sumNum > 0) {
                        while (j < k && nums[k] == nums[--k]) {
                        }
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[++j]) {
                        }
                        while (j < k && nums[k] == nums[--k]) {
                        }
                    }
                }
            }
        }
        return res;
    }
}
