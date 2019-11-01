package org.songzxdev.leetcode.week01;

/**
 * 题号：136.只出现一次的数字
 * 标签：位运算
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) {
            xor ^= num;
        }
        return xor;
    }
}
