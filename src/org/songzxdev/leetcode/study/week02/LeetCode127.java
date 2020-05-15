package org.songzxdev.leetcode.study.week02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        int step = 1;
        Set<String> wordSet = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            step++;
            Set<String> nextSet = new HashSet<>();
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (old != j) {
                            wordArray[i] = j;
                            String target = String.valueOf(wordArray);
                            if (endSet.contains(target)) {
                                return step;
                            }
                            if (wordSet.remove(target)) {
                                nextSet.add(target);
                            }
                        }
                    }
                    wordArray[i] = old;
                }
            }
            beginSet = nextSet;
        }
        return 0;
    }
}
