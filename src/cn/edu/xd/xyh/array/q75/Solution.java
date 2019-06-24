package cn.edu.xd.xyh.array.q75;

/**
 * @author LitheLight
 * @date 2019/6/24
 * https://leetcode.com/problems/sort-colors/
 * 可以设置三个指针，red表示连续的0的后一个位置，blue表示连续的2的前一个位置，
 * 开始的时候red=0， blue=nums.length-1。然后再设一个point指针遍历数组，
 * nums[point]==0时，将它和red位置的元素交换，然后red+1，point+1，为什么交换后point位置不用再判断直接加1了呢？
 * 是因为point位置的元素一定为1，所以不用判断.，看完后面的解释就清楚了
 * nums[point]==1时，直接point+1
 * nums[point]==2时，将它和blue位置的元素交换，然后blue-1 ,point不变，这里交换后point不能直接加1，
 * 因为换回来的元素可能是0或者2，需要再一次判断
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int red = 0;
        int blue = nums.length - 1;
        int point = 0;
        while (point <= blue) {
            if (nums[point] == 0) {
                swap(nums, red, point);
                red++;
                point++;
            } else if (nums[point] == 2) {
                swap(nums, blue, point);
                blue--;
            } else {
                point++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
