package org.songzxdev.leetcode.homework.week01;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组

public class LeetCode_66_1034 {
    /**
     * 题目：66.加一（https://leetcode-cn.com/problems/plus-one/）
     * 学号：1034（五期一班三组）
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        for (int k = p; k >= 0; k--) {
            if (digits[k] < 9) {
                digits[k]++;
                return digits;
            }
            digits[k] = 0;
        }
        int[] more = new int[digits.length + 1];
        more[0] = 1;
        return more;
    }
}
