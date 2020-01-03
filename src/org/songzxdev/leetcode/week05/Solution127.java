package org.songzxdev.leetcode.week05;

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索


import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, ArrayList<String>> treeMap = new HashMap<>(16);
        final int LEN = endWord.length();
        wordList.forEach(word -> {
            for (int k = 0; k < LEN; k++) {
                String statusKey = word.substring(0, k) + '*' + word.substring(k + 1);
                ArrayList<String> tmpList = treeMap.getOrDefault(statusKey, new ArrayList<>(16));
                tmpList.add(word);
                treeMap.put(statusKey, tmpList);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>() {{
            add(new Pair<>(beginWord, 1));
        }};
        Set<String> visited = new HashSet<String>() {{
            add(beginWord);
        }};

        while (queue.size() > 0) {
            Pair<String, Integer> pair = queue.poll();
            for (int k = 0; k < LEN; k++) {
                String statusKey = pair.getKey().substring(0, k) + '*' + pair.getKey().substring(k + 1);
                if (treeMap.containsKey(statusKey)) {
                    for (String word : treeMap.get(statusKey)) {
                        if (word.equals(endWord)) {
                            return pair.getValue() + 1;
                        } else if (!visited.contains(word)) {
                            visited.add(word);
                            queue.add(new Pair<>(word, pair.getValue() + 1));
                        }
                    }
                    treeMap.put(statusKey, new ArrayList<>());
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution127 s127 = new Solution127();
        int ans = s127.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

