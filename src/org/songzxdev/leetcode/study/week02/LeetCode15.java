package org.songzxdev.leetcode.study.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length, first = nums[0];
        List<List<Integer>> res = new ArrayList<>(16);
        for (int i = 0; i < n - 2 && first <= 0; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int add = nums[i] + nums[j] + nums[k];
                    if (add == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[++j]) {}
                        while (j < k && nums[k] == nums[--k]) {}
                    } else if (add < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
