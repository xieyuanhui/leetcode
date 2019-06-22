package cn.edu.xd.myy.binary_search;

/**
 * @author myy
 * @date 2019/6/22
 */
public class q34 {
    /**
     * 先二分查找，找到目标值的下标，
     * 然后从这个下标开始，往左往右查找和她相等的
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums,int target){
        int[] res ={-1,-1};
        if(nums == null|| nums.length<=0){
            return res;
        }
        int left = 0;
        int right=nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                index = mid;
                break;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(index == -1){
            return res;
        }
        int begin = index;
        int end = index;
        while((begin-1)>=0 && nums[begin-1]==target){
            begin--;
        }
        while((end+1)< nums.length && nums[end+1]==target){
           end++;
        }
        res[0]=begin;
        res[1]=end;
        return res;
    }
}
