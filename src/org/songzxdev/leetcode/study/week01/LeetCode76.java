package org.songzxdev.leetcode.study.week01;
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
// 示例：
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//
// 说明：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window


public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (strIsNull(s) || strIsNull(t) || s.length() < t.length()) {
            return "";
        }
        int tLen = t.length(), i = 0, j = 0, start = 0, found = 0, minLen = 0x7fffffff;
        int[] count = getStrCount(t), winds = new int[256];
        while (j < s.length()) {
            if (found < tLen) {
                char before = s.charAt(j++);
                if (count[before] > 0) {
                    if (++winds[before] <= count[before]) {
                        found++;
                    }
                }
            }
            while (found == tLen) {
                int sub = j - i;
                if (sub < minLen) {
                    start = i;
                    minLen = sub;
                }
                char after = s.charAt(i++);
                if (count[after] > 0) {
                    if (--winds[after] < count[after]) {
                        found--;
                    }
                }
            }
        }
        return minLen == 0x7fffffff ? "" : s.substring(start, start + minLen);
    }

    private boolean strIsNull(String str) {
        return str == null || str.trim().length() == 0;
    }

    private int[] getStrCount(String t) {
        int[] count = new int[256];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }
        return count;
    }
}
