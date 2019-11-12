package org.songzxdev.leetcode.week03;

//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//
// 示例：
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
// 输出: ["Alaska", "Dad"]
// 注意：
// 你可以重复使用键盘上同一字符。
// 你可以假设输入的字符串将只包含字母。
// Related Topics 哈希表

import java.util.*;

/**
 * 题目：500.键盘行
 * 标签：哈希表
 */
public class Solution500 {
    private final static Set<String> SET1 = new HashSet<>(Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
    private final static Set<String> SET2 = new HashSet<>(Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L", "a", "s", "d", "f", "g", "h", "j", "k", "l"));
    private final static Set<String> SET3 = new HashSet<>(Arrays.asList("Z", "X", "C", "V", "B", "N", "M", "z", "x", "c", "v", "b", "n", "m"));

    private Map<Character, Integer> getWordMap() {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);
            }
        }
        return map;
    }

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = getWordMap();
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            int index = map.get(word.toUpperCase().charAt(0));
            for (char c : word.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if(index != -1) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    /**
     * 性能有问题
     *
     * @param words
     * @return
     */
    public String[] findWords2(String[] words) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            Set<String> wdSet = new HashSet<>(Arrays.asList(word.split("")));
            if (SET1.containsAll(wdSet) || SET2.containsAll(wdSet) || SET3.containsAll(wdSet)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

}
