package org.songzxdev.leetcode.week03;

import java.util.HashMap;

public class Solution076 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> ttCountMap = new HashMap<>(16),
                winMap = new HashMap<>(16);
        for (Character cTt : t.toCharArray()) {
            ttCountMap.put(cTt, ttCountMap.getOrDefault(cTt, 0) + 1);
        }
        int left = 0, right = 0, match = 0, start = 0, minLen = s.length() + 1;
        while (left <= right && right < s.length()) {
            char rightKey = s.charAt(right);
            if (ttCountMap.containsKey(rightKey)) {
                winMap.put(rightKey, winMap.getOrDefault(rightKey, 0) + 1);
                if (winMap.get(rightKey).equals(ttCountMap.get(rightKey))) {
                    match++;
                }
            }
            right++;
            while (match == ttCountMap.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char leftKey = s.charAt(left);
                if (ttCountMap.containsKey(leftKey)) {
                    winMap.put(leftKey, winMap.get(leftKey) - 1);
                    if (winMap.get(leftKey) < ttCountMap.get(leftKey)) {
                        match--;
                    }
                }

                left++;
            }

        }
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
