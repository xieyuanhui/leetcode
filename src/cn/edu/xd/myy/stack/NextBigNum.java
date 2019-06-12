package cn.edu.xd.myy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/comments/
 *
 * 下一个更大的元素
 *利用HashMap存储num2中元素所对应的下一个更大元素（key-value : 当前元素-下一个更大元素）
 * 当当前元素小于栈顶元素时，继续入栈；当当前元素大于栈顶元素时，栈顶元素出栈，同时与当前元素形成key-value存入HashMap中
 * 遍历num1在hashMap中查找下一个最大元素，找不到时为1
 *
 */

public class NextBigNum {
    public int[] nextGreaterElement(int[] num1,int[] num2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i=0;i<num2.length;i++){
            //注意此处为while循环
            while(!stack.isEmpty()&&stack.peek()<num2[i]){
                hashmap.put(stack.pop(),num2[i]);
            }
            stack.push(num2[i]);
        }

        int[] result = new int[num1.length];
        for(int i=0;i<num1.length;i++){
            if(hashmap.containsKey(num1[i])){
                result[i]=hashmap.get(num1[i]);
            }else{
                result[i]=-1;
            }
        }
        return result;
    }

    public static  void main(String[] args){
        NextBigNum nbg = new NextBigNum();
        int[] num1={2,4};
        int[] num2 = {1,2,3,4};
       int[] res= nbg.nextGreaterElement(num1,num2);
       for(int r : res){
           System.out.println(r);
        }
    }
}
