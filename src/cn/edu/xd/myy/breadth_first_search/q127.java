package cn.edu.xd.myy.breadth_first_search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * @author myy
 * @date 2019/6/19
 */
public class q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) {
                    return steps + 1;
                }
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String cur = iterator.next();
                    if (canTransForm(temp, cur)) {
                        iterator.remove();//避免死循环
                        q.offer(cur);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    //判断两个单词是否可以转换
    public boolean canTransForm(String word1, String word2) {
        for (int i = 0, count = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && ++count > 1) {
                return false;
            }
        }
        return true;
    }
}
