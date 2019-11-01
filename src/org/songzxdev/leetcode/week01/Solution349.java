package org.songzxdev.leetcode.week01;

import java.util.HashSet;
import java.util.Set;

/**
 * 题号：349.两个数组的交集
 * 标签：哈希表
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (Integer n1 : nums1) {
            numSet.add(n1);
        }
        for (Integer n2 : nums2) {
            if (numSet.contains(n2)) {
                res.add(n2);
            }
        }

        int[] ans = new int[res.size()];
        int k = 0;
        for(Object obj: res) {
            ans[k++] = (int) obj;
        }
        return ans;
    }

}
