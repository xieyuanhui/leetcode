package cn.edu.xd.myy.stack;

import java.util.Stack;

/**
 https://leetcode-cn.com/problems/min-stack/

 最小栈 ： 利用一个辅助栈存储最小值实现
 */
class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> mindata;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        mindata = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        data.push(x);
        if(x<min){
            mindata.push(x);
            min = x;
        }else{
            mindata.push(min);
        }

    }

    public void pop() {
        if(data.size() <=0 && mindata.size()<=0 ){
            return;
        }
        data.pop();
        mindata.pop();
        //注意空值的判断
        min=mindata.isEmpty()? Integer.MAX_VALUE:mindata.peek();

    }

    public int top() {
        return data.peek();

    }

    public int getMin() {
        return mindata.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */