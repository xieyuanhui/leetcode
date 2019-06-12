package cn.edu.xd.xyh;

import java.util.Arrays;

/**
 * @author LitheLight
 * @date 2019/6/12
 *
 * https://leetcode-cn.com/problems/min-stack/
 * 是基于数组来操作的
 */
class MinStack {

    private int[] element;
    /**
     * 数组中有效部分的最小值
     */
    private int min;
    /**
     * 数组中有效部分的长度
     */
    private int size;
    /**
     * 数组初始长度
     */
    private int THRESHOLD = 16;

    /** initialize your data structure here. */
    public MinStack() {
        element = new int[THRESHOLD];
        min = Integer.MAX_VALUE;
        size = 0;
    }

    public void push(int x) {
        size++;
        // 有效长度大于数组长度时需要扩容
        if (size > element.length) {
            resize(size * 2);
        }
        element[size - 1] = x;
        min = Math.min(x, min);
    }

    public void pop() {
        if (size == 0) {
            throw new RuntimeException("No element!");
        }
        int e = element[size - 1];
        size--;
        // 数组有效部分最小值被弹出需要重新赋值最小值
        if (e == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(element[i], min);
            }
        }
        // 有效部分长度小于数组一半长度时缩小数组长度
        if (size < element.length / 2) {
            resize(element.length / 2);
        }
    }

    public int top() {
        return element[size - 1];
    }

    public int getMin() {
        return min;
    }

    /**
     * 修改数组长度
     * @param newSize
     */
    private void resize(int newSize) {
        element = Arrays.copyOf(element, newSize);
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
