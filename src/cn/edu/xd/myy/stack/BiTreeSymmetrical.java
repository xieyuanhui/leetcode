package cn.edu.xd.myy.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 判断一个二叉树是不是对称二叉树：利用前序遍历的思想判断， 根左右 == 根右左
 */


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class BiTreeSymmetrical {
      //递归解决
//    public boolean isSymmetric(TreeNode root){
//        if(root==null)
//            return true;
//        return isSymmetrical(root.left,root.right);
//    }
//    public boolean isSymmetrical(TreeNode left,TreeNode right){
//        if(left == null && right == null)
//            return true;
//        if(left==null || right == null)
//            return false;
//        if(left.val != right.val)
//            return false;
//        return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
//    }

    //非递归解决
    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(right == null && left == null) return true;
            if(right == null || left == null) return false;
            if(right.val != left.val) return false;
            //注意需要成对的压栈 弹栈
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

}
