package org.songzxdev.leetcode.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题号：219
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * Related Topics 数组 哈希表
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, ArrayList<Integer>> numMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ArrayList<Integer> idxLst = numMap.getOrDefault(num, new ArrayList<>());
            idxLst.add(i);
            if (idxLst.size() >= 2) {
                if (idxLst.get(idxLst.size() - 1) - idxLst.get(idxLst.size() - 2) <= k) {
                    return true;
                }
            }
            numMap.put(num, idxLst);

        }
        return false;
    }

}
