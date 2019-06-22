package cn.edu.xd.myy.dynamic_programming;

import java.util.List;

/**
 * @author myy
 * @date 2019/6/21
 */
public class q139 {
    /**
     * dp[i]表示字符串中第一个字符到第i个字符能否由dict里面的单词组成
     * 遍历第一个字符到第i个字符，如果第一个字符到第j个字符可以由字典表示并且第j+1个字符到第i个字符组成的字符串在字典里，
     * 那么dp[i]=true
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}
