package cn.edu.xd.myy.Tree;

import cn.edu.xd.myy.Tree.TreeNode;



/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/comments/
 *
 * 二叉搜索树中第k小的数：其实就是中序遍历序列中的第k个元素
 */


public class BiTreeKSmall {

    public int count =0;
    public int res ;


    public int kthSmallest(TreeNode root, int k){
        inOrder(root,k);
        return res;
    }
    public void inOrder(TreeNode root,int k){
        if(root != null){
            inOrder(root.left,k);
            count++;
            if(count == k) {
                res = root.val;
                return;
            }
            inOrder(root.right,k);
        }
    }
}
