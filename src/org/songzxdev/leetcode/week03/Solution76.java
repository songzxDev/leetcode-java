package org.songzxdev.leetcode.week03;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：76.最小覆盖子串
 * 标签：哈希表 双指针 字符串
 * 超时版代码
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tCountMap = new HashMap<>(16);
        for (Character tc : t.toCharArray()) {
            tCountMap.put(tc, tCountMap.getOrDefault(tc, 0) + 1);
        }
        int left = 0, right = 0;
        HashMap<Character, Integer> tMap = new HashMap<>(16);
        tMap.putAll(tCountMap);
        int[] res = new int[]{0, s.length()};
        while (left <= right && right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                int afterMinus = tMap.get(s.charAt(right)) - 1;
                if (afterMinus > 0) {
                    tMap.put(s.charAt(right), afterMinus);
                } else {
                    final Character removeKey = s.charAt(right);
                    tMap.keySet().removeIf(key -> key.equals(removeKey));
                }
            }
            right++;
            if (tMap.isEmpty()) {
                if (res[1] - res[0] > right - left) {
                    res[0] = left;
                    res[1] = right;
                }
                tMap.putAll(tCountMap);
                left++;
                right = left;
            }

        }
        return left == 0 ? "" : s.substring(res[0], res[1]);
    }

    public static void main(String[] args) {
        Solution76 s76 = new Solution76();
        System.out.println(s76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
