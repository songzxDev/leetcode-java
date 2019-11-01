package org.songzxdev.leetcode.week01;

/**
 * 69.x的平方根
 * 标签：数学
 */
public class Solution69 {


    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }


}
