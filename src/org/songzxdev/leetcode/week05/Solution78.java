package org.songzxdev.leetcode.week05;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(16);
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmpList = new ArrayList<>(16);
            for (List<Integer> sub : res) {
                List<Integer> coolie = new ArrayList<>(sub);
                coolie.add(num);
                tmpList.add(coolie);
            }
            res.addAll(tmpList);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution78 slt78 = new Solution78();
        System.out.println(slt78.subsets(new int[]{1, 2, 3}).toString());
    }
}
