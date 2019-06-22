package cn.edu.xd.myy.dynamic_programming;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * @author myy
 * @date 2019/6/21
 */
public class q198 {
    /**
     * dp[i]表示前i个房子能够得到的最大金额
     *
     * 情况一：第i个房子抢劫，那么第i-1个房子不能抢劫，dp[i]=dp[i-2]+nums[i]
     * 情况二：第i个房子不抢劫，dp[i]=dp[i-1]
     * 取两种情况的最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        if(nums==null || nums.length<=0)
            return 0;
        int[] d = new int[nums.length+1];
        d[0]=0;
        d[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            d[i]=Math.max(d[i-2]+nums[i-1],d[i-1]);
        }
        return d[nums.length];
    }

}
