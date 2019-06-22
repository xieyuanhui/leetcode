package cn.edu.xd.myy.dynamic_programming;

/**
 * @author myy
 * @date 2019/6/21
 */
public class q70 {
    //动态规划 dp[i]=dp[i-1]+dp[i-2]
    public int climbStairs(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

}
