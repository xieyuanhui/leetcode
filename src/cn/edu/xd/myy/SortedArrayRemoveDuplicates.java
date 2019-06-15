package cn.edu.xd.myy;

/**
 * q26: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 *排好序的数组中去除重复
 * @author myy
 * @date 2019/6/15
 */
public class SortedArrayRemoveDuplicates {
    /**
     * 利用两个指针实现，一个快一个慢，
     * 当快指针指向的值等于慢指针指向的值，直接跳过，
     * 当快指针指向的值不等于慢指针的值，将快指针的值复制到慢指针加1的位置
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int slow =0;
        int fast = slow+1;
        for(;fast<nums.length;fast++){
            if(nums[fast]==nums[slow]){
                continue;
            }else{
                nums[slow+1]=nums[fast];
                slow++;
            }
        }
        return slow+1;
    }
}
