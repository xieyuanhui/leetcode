package cn.edu.xd.myy.dynamic_programming;

/**
 * @author myy
 * @date 2019/6/21
 */
public class q53 {
    /**
     * 子序列的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length <=0){
            return Integer.MIN_VALUE;
        }
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0){
                //表明前i-1个数组的和小于0，所以0 ~（i - 1）这个序列不要，直接让sum = 0就相当于情况
                sum =0;
            }
            sum+= nums[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}
