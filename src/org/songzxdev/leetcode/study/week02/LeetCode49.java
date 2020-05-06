package org.songzxdev.leetcode.study.week02;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>(16);
        for (String str: strs) {
            int numKey = getNumKey(str);
            map.putIfAbsent(numKey, new ArrayList<>(16));
            map.get(numKey).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private int getNumKey(String str) {
        int numKey = 1;
        for (int i = 0; i < str.length(); i++) {
            numKey *= PRIMES[str.charAt(i) - 'a'];
        }
        return numKey;
    }
}
