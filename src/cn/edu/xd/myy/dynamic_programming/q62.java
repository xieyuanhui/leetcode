package cn.edu.xd.myy.dynamic_programming;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * @author myy
 * @date 2019/6/21
 */
public class q62 {
    /**
     * dp[i][j]表示从(0,0)到（i,j)有多少条不同的路径
     * 对于第一行，和和第一列，只有一种路径可到达，所以dp[i][j]=1;
     * 对于其他点 dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m,int n){
        if(m<1 && n<1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0;i< n;i++){
            dp[0][i]=1;
        }
        for(int j=0;j<m;j++){
            dp[j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
