package cn.edu.xd.myy.breadth_first_search;

import java.util.*;

/**
 * @author myy
 * @date 2019/6/19
 */
public class q102BinaryTreeLevelOrderTraversal {
    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        bfs(root,res,0);
        return res;
    }
    public void bfs(TreeNode root,List<List<Integer>> res,int level){
        if(root == null){
            return ;
        }
        if(res.size()<(level+1)){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        bfs(root.left,res,level+1);
        bfs(root.right,res,level+1);
    }

    /**
     * 利用双端队列实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.removeFirst();
                size--;
                list.add(node.val);
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
