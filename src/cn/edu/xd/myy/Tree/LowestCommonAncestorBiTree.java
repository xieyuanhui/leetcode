package cn.edu.xd.myy.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
 * 最近的公共父节点
 */

public class LowestCommonAncestorBiTree {
    //递归遍历
    /**
     * 如果要找的两个节点p q位于root的两边，那么这个节点root就是p q的最近公共子节点
     * 如果两个节点位于同一侧，即left 或者 right 返回值为null，那么另一边的返回值就是他们最小的公共父节点
     *
     * 递归的出口是 没有找到 p q,则返回null,;只要碰到p q 就立即返回
     */

//    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
//        if(root == null)
//            return null;
//        if(root == p || root == q)
//            return root;
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        if(left!=null && right != null)
//            return root;
//       return left!= null? left:right;
//
//    }

    /*
    * 非递归的写法，利用一个hashmap 存储节点的父节点信息（key是当前节点，value是父节点的信息）
    * 利用栈存储二叉树的遍历过程
    *
    * */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){

        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        parent.put(root,null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left!= null){
                parent.put(node.left,node);
                stack.push(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }

        //新建一个set用于存储p的所有父节点的信息
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p=parent.get(p);
        }

        //找到q的第一个出现在p的set集合中的父节点
        while(!ancestors.contains(q)){
            q=parent.get(q);
        }
        return q;
    }

}
