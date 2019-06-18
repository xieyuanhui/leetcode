package cn.edu.xd.myy.depth_first_search;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * q104:二叉树的最大深度
 * @author myy
 * @date 2019/6/18
 */
public class q104MaximumDepthBinaryTree {
    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);

    }

    /**
     * 广度优先遍历。层序遍历，利用队列实现
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int ans=0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ans++;
            int size=queue.size();
            while(size >0){
                TreeNode node = queue.removeFirst();
                if(node.left != null) queue.addLast(node.left);
                if(node.right!=null) queue.addLast(node.right);
                size--;
            }
        }
        return ans;
    }
}
