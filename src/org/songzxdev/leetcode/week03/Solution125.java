package org.songzxdev.leetcode.week03;

import java.util.regex.Pattern;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
// 说明：本题中，我们将空字符串定义为有效的回文串。
// 示例 1:
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 示例 2:
// 输入: "race a car"
//输出: false
// Related Topics 双指针 字符串

public class Solution125 {

    /**
     * 题目：125.验证回文串
     * 标签：字符串 双指针
     * 不使用java 自带的替换字符串的replaceAll()函数，速度会快一些，双指针碰到字母和数字才比较，否则头尾指针依次递增或递减
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i <= j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 题目：125.验证回文串
     * 标签：字符串 双指针
     *
     * @param s
     * @return
     */
    public boolean isPalindromeSlow(String s) {
        if (s == null) {
            return false;
        }
        // java 正则替换字符串还是有点慢
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
