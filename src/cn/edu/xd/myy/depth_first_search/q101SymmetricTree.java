package cn.edu.xd.myy.depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**https://leetcode.com/problems/symmetric-tree/
 * q101: 对称二叉树的判断
 * @author myy
 * @date 2019/6/18
 */
public class q101SymmetricTree {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
        return true;
        }
        if(t1==null || t2==null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }

    /**
     * 非递归的方法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror2(root);
    }

    //利用队列实现
    public boolean isMirror2(TreeNode t){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t);
        queue.add(t);
        while(!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if(p1==null && p2 == null) continue;
            if(p1==null || p2==null) return false;
            if(p1.val != p2.val) return false;
            queue.add(p1.left);
            queue.add(p2.right);
            queue.add(p1.right);
            queue.add(p2.left);
        }
        return true;
    }

}
