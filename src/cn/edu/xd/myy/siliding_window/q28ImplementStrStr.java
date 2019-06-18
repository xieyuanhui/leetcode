package cn.edu.xd.myy.siliding_window;

/**
 * https://leetcode.com/problems/implement-strstr/
 * q28
 * @author myy
 * @date 2019/6/17
 */
public class q28ImplementStrStr {
    //暴力法求解
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()){
            return -1;
        }
        if(haystack.length()==0&& needle.length()==0){
            return 0;
        }
        for(int i =0;i<= (haystack.length()-needle.length());i++){

            boolean found = true;
            for(int j=0;j<=needle.length()-1;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    found=false;
                    break;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;

    }
}
