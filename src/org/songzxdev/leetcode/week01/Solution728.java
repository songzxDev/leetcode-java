package org.songzxdev.leetcode.week01;

import java.util.*;

/**
 * 题号：728.自除数
 * 标签：数学
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String[] divi = (i + "").split("");
            boolean sign = true;
            for (String d : divi) {
                if (Integer.parseInt(d) == 0 || i % Integer.parseInt(d)  != 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                res.add(i);
            }
        }
        return res;
    }
}
