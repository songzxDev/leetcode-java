package org.songzxdev.leetcode.week03;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯，需要n阶你才能到达楼顶，每次只能爬一阶或者两阶楼梯，问：共有多少种方法可以爬到楼顶？
 * 注意：给定的n是个正整数
 * 题目：70.爬楼梯
 * 标签：递归 数组 动态规划
 */
public class Solution70 {
    /**
     * 思路：假设已经爬到了n阶楼梯，往后退，只能退到n-1阶楼梯或者n-2阶楼梯，那么可以视为：爬到n阶楼梯的方法
     * 为爬到第n-1阶楼梯的方法加上第n-1阶楼梯的方法所得到的和，即：斐波那契数列 f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> tmpMap = new HashMap<>(16);
        tmpMap.put(1, 1);
        tmpMap.put(2, 2);
        for (int i = 3; i <= n; i++) {
            tmpMap.put(i, tmpMap.get(i - 1) + tmpMap.get(i - 2));
        }
        return tmpMap.get(n);
    }
}
