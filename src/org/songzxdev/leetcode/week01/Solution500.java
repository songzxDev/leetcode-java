package org.songzxdev.leetcode.week01;


import java.util.*;

public class Solution500 {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = getWordMap();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();
            if (word.length() <= 1) {
                res.add(words[i]);
            } else {
                String lineNum = map.get(word.charAt(0) + "");
                for (int j = 1; j < word.length(); j++) {
                    if (!(map.get(word.charAt(j) + "").equals(lineNum))) {
                        break;
                    } else {
                        if (j == word.length() - 1) {
                            res.add(words[i]);
                        }
                    }

                }

            }

        }
        String[] resArr = new String[res.size()];
        return res.toArray(resArr);
    }

    private Map<String, String> getWordMap() {
        Map<String, String> wordMap = new HashMap<>(16);
        wordMap.put("Q", 0 + "");
        wordMap.put("W", 0 + "");
        wordMap.put("E", 0 + "");
        wordMap.put("R", 0 + "");
        wordMap.put("T", 0 + "");
        wordMap.put("Y", 0 + "");
        wordMap.put("U", 0 + "");
        wordMap.put("I", 0 + "");
        wordMap.put("O", 0 + "");
        wordMap.put("P", 0 + "");
        wordMap.put("A", 1 + "");
        wordMap.put("S", 1 + "");
        wordMap.put("D", 1 + "");
        wordMap.put("F", 1 + "");
        wordMap.put("G", 1 + "");
        wordMap.put("H", 1 + "");
        wordMap.put("J", 1 + "");
        wordMap.put("K", 1 + "");
        wordMap.put("L", 1 + "");
        wordMap.put("Z", 2 + "");
        wordMap.put("X", 2 + "");
        wordMap.put("C", 2 + "");
        wordMap.put("V", 2 + "");
        wordMap.put("B", 2 + "");
        wordMap.put("N", 2 + "");
        wordMap.put("M", 2 + "");
        return wordMap;
    }

}


