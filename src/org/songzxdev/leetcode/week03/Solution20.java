package org.songzxdev.leetcode.week03;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目：20.有效的括号
 * 标签：栈 字符串
 */
public class Solution20 {
    public boolean isValid(String strs) {
        Stack<Character> stack = new Stack<>();
        for (Character chr : strs.toCharArray()) {
            if (chr == '(') {
                stack.push(')');
            } else if (chr == '{') {
                stack.push('}');
            } else if (chr == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || !stack.pop().equals(chr)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
