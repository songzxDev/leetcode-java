package org.songzxdev.leetcode.week03;

import java.util.HashMap;
import java.util.Map;

public class Solution0076 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> ttCount = new HashMap<>(16), window = new HashMap<>(16);
        for (Character tc : t.toCharArray()) {
            ttCount.put(tc, ttCount.getOrDefault(tc, 0) + 1);
        }
        int left = 0, right = 0, match = 0, start = 0, minLen = s.length() + 1;
        while (left <= right && right < s.length()) {
            char rightKey = s.charAt(right);
            if (ttCount.containsKey(rightKey)) {
                window.put(rightKey, window.getOrDefault(rightKey, 0) + 1);
                if (window.get(rightKey).equals(ttCount.get(rightKey))) {
                    match++;
                }
            }
            right++;

            while (match == ttCount.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char leftKey = s.charAt(left);
                if (ttCount.containsKey(leftKey)) {
                    window.put(leftKey, window.get(leftKey) - 1);
                    if (window.get(leftKey) < ttCount.get(leftKey)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
