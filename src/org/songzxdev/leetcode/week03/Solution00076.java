package org.songzxdev.leetcode.week03;

public class Solution00076 {
    /**
     * 题目：76.最小覆盖子串
     * 标签：滑动窗口 双指针 哈希表
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] tCount = new int[256], window = new int[256];
        for (char ct : t.toCharArray()) {
            tCount[ct]++;
        }
        int left = 0, right = 0, match = 0, start = 0, minLen = s.length() + 1;
        while (left <= right && right < s.length()) {
            if (match < t.length()) {
                char rightKey = s.charAt(right);
                if (tCount[rightKey] > 0) {
                    window[rightKey]++;
                    if (window[rightKey] <= tCount[rightKey]) {
                        match++;
                    }
                }
                right++;
            }

            while (match == t.length()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char leftKey = s.charAt(left);
                if (tCount[leftKey] > 0) {
                    window[leftKey]--;
                    if (window[leftKey] < tCount[leftKey]) {
                        match--;
                    }
                }
                left++;
            }

        }
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
