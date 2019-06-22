package cn.edu.xd.myy.dynamic_programming;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * q5 最长回文子串的判断
 * @author myy
 * @date 2019/6/20
 */
public class q5LongestPalindromicSubstring {
    /**
     * 动态规划求解 d[i][j]=1表示字符串i,j之间是回文子串
     * d[i][j] = d[i+1][j-1]&&s[i]==s[j]
     *
     * 只有一个字符的时候 d[i][i]=1
     * 两个字符的时候 d[i][i+1]= s[i]==s[i+1]
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if(s==null || s.length() <=0){
            return null;
        }
        int n = s.length();

        int start =0;
        int end =0;
        int max=1;//字符串不为空时，至少为一个字符

        int[][] d = new int[n][n];
        for(int i=0;i<n;i++){
            d[i][i]=1;
            if(i<n-1){
                if(s.charAt(i)==s.charAt(i+1)){
                    d[i][i+1]=1;
                    start = i;
                    end =i+1;
                    max=2;
                }else{
                    d[i][i+1]=0;
                }
            }

        }

        for(int l= 3;l<= n;l++){//子串长度
            for(int i=0;i+l-1 < n;i++){//枚举子串的起始点
                int j = i+l-1;//终点
                if(s.charAt(i)==s.charAt(j) && d[i+1][j-1]==1){
                    d[i][j]=1;
                    if(j-i+1 > max){
                        start = i;
                        end = j;
                        max = j-i+1;
                    }
                }else{
                    d[i][j]=0;
                }

            }
        }
        return s.substring(start,end+1);

    }
}

