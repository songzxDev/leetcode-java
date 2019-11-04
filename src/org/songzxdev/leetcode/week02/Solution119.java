package org.songzxdev.leetcode.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：119.杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * Related Topics 数组
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        int prev = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int temp = curr.get(j);
                curr.set(j, prev + curr.get(j));
                prev = temp;
            }
            curr.add(1);
        }
        return curr;
    }
}
