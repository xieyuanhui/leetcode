package cn.edu.xd.myy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author myy
 * @date 2019/6/15
 * https://leetcode.com/problems/two-sum/
 * q1  : 两数求和
 */
public class TwoSum {
    /**
     * 两遍遍历hashmap，注意返回的下标不能是她自己
     */
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int reverse = target-nums[i];
            if(map.containsKey(reverse) && map.get(reverse)!=i){
                return new int[]{i,map.get(reverse)};
            }
        }
        throw new IllegalArgumentException("No two Solution");
    }

    /**
     * 一边遍历hashmap
     */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int reverse = target-nums[i];
            if(map.containsKey(reverse)){
                return new int[]{i,map.get(reverse)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
