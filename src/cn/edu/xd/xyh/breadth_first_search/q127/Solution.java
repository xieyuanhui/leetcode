package cn.edu.xd.xyh.breadth_first_search.q127;

import javafx.util.Pair;

import java.util.*;

/**
 * @author LitheLight
 * @date 2019/6/19
 * https://leetcode.com/problems/word-ladder/
 * 官方题解：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformation = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformation.add(word);
                allComboDict.put(newWord, transformation);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<>();
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

}
