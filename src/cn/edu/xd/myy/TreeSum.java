package cn.edu.xd.myy;


import java.util.*;

/**
 * q15
 *
 * @author myy
 * @date 2019/6/15
 */
public class TreeSum {

    /**只要一重循环从左到右遍历数组，作为三元组的第一个数字。
     * 剩下的两个数字在第一个数字的右边寻找：定义两个指针，一头一尾，向中间合拢，只要三数之和不等于0，就选择其中一个指针向中间移动。
     *
     * 需要将数组进行排序，方便判断需要移动哪个指针：当三数之和大于0，则尾指针向左移动；
     * 否则 将头指针向右移动
     *
     * 利用HashSet存储结果，这样会使重复添加的元素无效
     *
     * 由于最后需要返回一个List,利用HashSet的iterator遍历，将结果返回到list中
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>>  res = new HashSet<>();

        if(nums==null || nums.length<3) {
            return result;
        }

        int left = 0;

        Arrays.sort(nums);
        for(;left<=(nums.length-1-2);left++){
            int mid = left+1;
            int right = nums.length-1;


            while(mid<right){
                int sum = nums[left]+nums[mid]+nums[right];
                if(sum >0){
                    right--;
                }else if(sum<0){
                    mid++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    res.add(temp);
                    mid++;
                    right--;
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
