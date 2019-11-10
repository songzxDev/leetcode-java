package org.songzxdev.leetcode.week02;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
// 找出所有满足条件且不重复的三元组。
// 注意：答案中不可以包含重复的三元组。
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics 数组 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：15.三数之和
 * 标签：双指针、数组
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(16);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k - 1] == nums[k]) {
                continue;
            }

            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    int leftNum = nums[left];
                    do {
                        left++;
                    } while (left < right && nums[left] == leftNum);

                } else if (sum > 0) {
                    int rightNum = nums[right];
                    do {
                        right--;
                    } while (left < right && nums[right] == rightNum);
                } else {
                    res.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    int leftNum = nums[left];
                    do {
                        left++;
                    } while (left < right && nums[left] == leftNum);
                    int rightNum = nums[right];
                    do {
                        right--;
                    } while (left < right && nums[right] == rightNum);
                }
            }
        }
        return res;
    }

}
