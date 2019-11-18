package org.songzxdev.leetcode.week04;

//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
// 示例：
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
// 说明：
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

public class Solution76 {
    /**
     * 题目：76.最小覆盖子串（滑动窗口 双指针）
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] tCount = new int[256], window = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        int left = 0, right = 0, find = 0, start = 0, minLen = s.length() + 1;
        while (right < s.length()) {
            if (find < t.length()) {
                if (tCount[s.charAt(right)] > 0) {
                    window[s.charAt(right)]++;
                    if (window[s.charAt(right)] <= tCount[s.charAt(right)]) {
                        find++;
                    }
                }
                right++;
            }
            while (find == t.length()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                if (tCount[s.charAt(left)] > 0) {
                    window[s.charAt(left)]--;
                    if (window[s.charAt(left)] < tCount[s.charAt(left)]) {
                        find--;
                    }
                }
                left++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);
    }
}
