package org.songzxdev.leetcode.week01;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：804.唯一摩尔斯密码词
 * 标签：字符串
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] sources = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder stb = new StringBuilder();
            for (char s : word.toCharArray()) {
                stb.append(sources[s - 97]);
            }
            set.add(stb.toString());
        }
        return set.size();
    }
}
