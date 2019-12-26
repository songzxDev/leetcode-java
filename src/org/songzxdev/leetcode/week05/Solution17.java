package org.songzxdev.leetcode.week05;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

public class Solution17 {
    private static final String[] MEMO = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(16);
        if (digits != null && digits.length() > 0) {
            helper(res, 0, "", digits);
        }
        return res;
    }

    private void helper(List<String> res, int level, String str, String digits) {
        if (level == digits.length()) {
            res.add(str);
            return;
        }
        String coolie = MEMO[digits.charAt(level) - '0'];
        for (char s : coolie.toCharArray()) {
            helper(res, level + 1, str + s, digits);
        }
    }


}
