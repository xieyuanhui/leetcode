package cn.edu.xd.myy.siliding_window;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * q3LongestSubstringWithoutRepeating:
 * @author myy
 * @date 2019/6/17
 */
public class q3LongestSubstringWithoutRepeating {
    /**
     * 利用map存储 字符和对应下标的位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null) {
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0,j=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){

                i = Math.max(i,map.get(s.charAt(j))+1);

            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j);


        }
        return ans;
    }

    public static void main(String[] args){
        q3LongestSubstringWithoutRepeating q = new q3LongestSubstringWithoutRepeating();
        String s= "pwwkew";
        System.out.println(q.lengthOfLongestSubstring(s));

    }
}
