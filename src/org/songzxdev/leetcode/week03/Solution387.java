package org.songzxdev.leetcode.week03;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
// 案例:
//s = "leetcode"
//返回 0.
//s = "loveleetcode",
//返回 2.
// 注意事项：您可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：387.字符串中的第一个唯一字符
 * 标签：哈希表 字符串
 */
public class Solution387 {
    public int firstUniqCharSlow(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>(16);
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (countMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    public int firstUniqChar(String str) {
        // 经测试使用数组来遍历和计数，效率比Map更快，leetcode 平均执行12ms，而Map需要54ms左右！
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
