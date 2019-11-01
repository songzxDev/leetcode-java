package org.songzxdev.leetcode.week01;

/**
 * 题号：709.转换成小写字母
 * 标签：字符串
 */
public class Solution709 {
    public String toLowerCase(String str) {
        if (str.length() == 0) {
            return "";
        } else {
            char[] abc = str.toCharArray();
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < abc.length; i++) {
                if (abc[i] >= 65 && abc[i] <= 90) {
                    abc[i] += 32;
                }
                stb.append(abc[i]);
            }
            return stb.toString();
        }

    }

}
