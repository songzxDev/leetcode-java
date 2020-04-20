package org.songzxdev.leetcode.study.week01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode49 {
    /**
     * 长度为26位的质数数组用于计算每个字符串的key值
     */
    private final static int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            int numKey = getKey(str);
            List<String> temp = map.getOrDefault(numKey, new ArrayList<>(16));
            temp.add(str);
            map.put(numKey, temp);
        }
        return new ArrayList<>(map.values());
    }

    private int getKey(String str) {
        int numKey = 1;
        for (int i = 0; i < str.length(); i++) {
            numKey *= PRIMES[str.charAt(i) - 97];
        }
        return numKey;
    }

}
