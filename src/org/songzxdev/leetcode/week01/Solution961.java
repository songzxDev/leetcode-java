package org.songzxdev.leetcode.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：961.重复N次的元素
 * 标签：哈希表
 */
public class Solution961 {
    public int repeatedNTimes(int[] A) {
        int middle = A.length / 2;
        Map<Integer, Integer> numMap = new HashMap<>(16);
        for (int a : A) {
            numMap.put(a, numMap.getOrDefault(a, 0) + 1);
        }
        for (Integer num : numMap.keySet()) {
            if (numMap.get(num) == middle) {
                return num;
            }
        }
        return middle;
    }
}
