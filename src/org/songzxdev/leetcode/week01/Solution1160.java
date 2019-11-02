package src.org.songzxdev.leetcode.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：1160.拼写单词
 * 标签：数组、哈希表
 */
public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        Map<Character, Integer> charMap = new HashMap<>(16);
        for (char cr : chars.toCharArray()) {
            charMap.put(cr, charMap.getOrDefault(cr, 0) + 1);
        }

        for (String wd : words) {
            Map<Character, Integer> copyed = new HashMap<>(16);
            copyed.putAll(charMap);
            boolean isHaveAll = true;
            for (Character w : wd.toCharArray()) {
                if (!copyed.containsKey(w) || copyed.get(w) == 0) {
                    isHaveAll = false;
                    break;
                } else {
                    copyed.put(w, copyed.get(w) - 1);
                }
            }
            if (isHaveAll) {
                ans += wd.length();
            }

        }
        return ans;
    }

}
