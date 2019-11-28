package org.songzxdev.leetcode.week04;

//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1:
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
//
//
// 示例 2:
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4]
//
// 说明:
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    /**
     * 题目：349.两个数组的交集
     * 标签：数组 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>(16);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int p = res.size();
        int[] inters = new int[p];
        for (Integer num : res) {
            inters[--p] = num;
        }
        return inters;
    }
}
