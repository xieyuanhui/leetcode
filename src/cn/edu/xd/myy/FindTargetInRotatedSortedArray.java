package cn.edu.xd.myy;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * q33
 *
 * @author myy
 * @date 2019/6/15
 */
public class FindTargetInRotatedSortedArray {
    /**
     * 核心思想还是二分查找
     *
     * 从左往右: 如果左边的点比右边的点小，那么说明这两个点之间是有序的
     *           如果左边的点比右边的点大，那么说明这两个点之间有个旋转点，
     *   所以一分为二之后，肯定有一半是有序的，所以还可以用二分查找。
     *
     *   需要先判断是左边有序还是右边有序，
     *   如果左边有序，则直接将目标与左边的边界比较，就知道目标在不在左边，
     *   如果不在左边肯定在右边
     *
     *   没有找到返回-1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length <=0){
            //throw new IllegalArgumentException("no find");
            return -1;
        }

        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<=nums[mid]){//左半段有序
                if(nums[left] <= target && nums[mid] >= target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            else{//右半段有序
                if(nums[mid]<= target && nums[right]>= target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;

    }
}
