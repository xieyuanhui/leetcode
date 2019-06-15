package cn.edu.xd.myy;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

/**
 * @author myy
 * @date 2019/6/15
 */
public class FourSum {
    /**
     * 与三数求和一个思路，只是多了一层循环
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<List<Integer>> res = new HashSet<>();

        if(nums==null|| nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for(int first = 0; first <= nums.length-4;first++){
            for(int left = first+1;left<=nums.length-3;left++){
                int mid = left+1;
                int right = nums.length-1;
                while(mid < right){
                    if(nums[first]+nums[left]+nums[mid]+nums[right]== target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[left]);
                        list.add(nums[mid]);
                        list.add(nums[right]);
                        res.add(list);
                        mid++;
                        right--;
                    }else if(nums[first]+nums[left]+nums[mid]+nums[right]< target){
                        mid++;
                    }else{
                        right--;
                    }
                }
            }
        }
        Iterator<List<Integer>> iter = res.iterator();
        while(iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }
}
