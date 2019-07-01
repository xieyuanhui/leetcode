package cn.edu.xd.xyh.hash_table.q49;

import java.util.*;

/**
 * @author LitheLight
 * @date 2019/7/1
 * https://leetcode.com/problems/group-anagrams/
 * 思路：
 * 将字符串数组中每个字符串里的字符排序，然后将它作为map的key，List<String>作为value
 * 存储有哪些字符串里的字符排序后是跟它相同的
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String keyStr = String.valueOf(chs);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
