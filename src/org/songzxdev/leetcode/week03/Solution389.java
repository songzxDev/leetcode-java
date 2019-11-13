package org.songzxdev.leetcode.week03;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例:
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
//
// Related Topics 位运算 哈希表

/**
 * 题目：389.找不同
 * 标签：位运算 哈希表
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for(char chr : s.concat(t).toCharArray()) {
            ans ^= chr;
        }
        return ans;
    }
}
