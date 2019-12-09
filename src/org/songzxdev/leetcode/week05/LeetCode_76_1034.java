package org.songzxdev.leetcode.week05;

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

public class LeetCode_76_1034 {
    /**
     * 题目：76.最小覆盖子串（https://leetcode-cn.com/problems/minimum-window-substring/）
     * 标签：双指针 字符串
     * 学号：1034
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        } else if (s.equals(t)) {
            return s;
        }
        int[] mapT = new int[256], wins = new int[256];
        for (char p : t.toCharArray()) {
            mapT[p]++;
        }
        int i = 0, j = 0, begin = 0, found = 0, minLen = s.length() + 2;
        while (j < s.length()) {
            if (found < t.length()) {
                char right = s.charAt(j);
                if (mapT[right] > 0) {
                    if (++wins[right] <= mapT[right]) {
                        found++;
                    }
                }
                j++;
            }
            while (found == t.length()) {
                if (j - i < minLen) {
                    begin = i;
                    minLen = j - i;
                }
                char left = s.charAt(i);
                if (mapT[left] > 0) {
                    if (--wins[left] < mapT[left]) {
                        found--;
                    }
                }
                i++;
            }
        }
        return minLen == s.length() + 2 ? "" : s.substring(begin, begin + minLen);
    }
}
