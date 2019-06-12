package cn.edu.xd.myy.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 下一个更大元素II
 *
 */
public class NextBigNum2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n= nums.length;
        int[] res= new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i< 2*n;i++){
            int index = i%n;
            while(!stack.isEmpty()&&nums[stack.peek()] < nums[index]){
               res[stack.pop()] = nums[index];
            }
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
    public static void main(String[] args){
        NextBigNum2 nbg2=new NextBigNum2();
        int[] num ={1,2,1};
        int[] res =nbg2.nextGreaterElements(num);
        for(int i : res){
            System.out.println(i);
        }
    }
}
