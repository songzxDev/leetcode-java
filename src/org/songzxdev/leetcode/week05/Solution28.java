package org.songzxdev.leetcode.week05;

//实现 strStr() 函数。
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
// 示例 1:
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 示例 2:
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串

public class Solution28 {

    /**
     * 题目：28.实现 strStr()
     * 标签：字符串 双指针
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length(), sub = len1 - len2;
        if (len1 == sub) {
            return 0;
        } else if (sub < 0) {
            return -1;
        }
        for (int i = 0; i <= sub; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
