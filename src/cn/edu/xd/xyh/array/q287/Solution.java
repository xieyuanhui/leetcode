package cn.edu.xd.xyh.array.q287;

/**
 * @author LitheLight
 * @date 2019/6/27
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 思路：
 * 这个问题可以转换为之前做过的找有环链表的入口的问题，比如针对输入[1,3,4,2,2]，我们从nums[0]开始建链表，
 * nums[0] = 1, nums[1] = 3, nums[3] = 2，nums[2] = 4, nums[4] = 2,
 * 那就是 1 -> 3 -> 2 -> 4 -> 2（环），4再指向2形成了环，
 * 然后就是使用快慢指针法
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast= nums[nums[0]];

        while(fast!=slow){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 2, 1};
        System.out.println(solution.findDuplicate(nums));
    }
}
