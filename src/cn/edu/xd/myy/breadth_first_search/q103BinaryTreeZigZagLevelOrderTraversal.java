package cn.edu.xd.myy.breadth_first_search;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * q103
 * @author myy
 * @date 2019/6/19
 */
public class q103BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean flag = true;
        while(!queue.isEmpty()){
                int size = queue.size();
                LinkedList<Integer> list = new LinkedList<>();
                while(size>0){
                    TreeNode node = queue.removeFirst();
                    size--;
                    if(node.left != null){queue.addLast(node.left);}
                    if(node.right!= null){queue.addLast(node.right);}
                    if(flag){
                        list.addLast(node.val);
                    }else{
                        list.addFirst(node.val);
                    }
            }
                res.add(list);
                flag=!flag;
        }
        return res;
    }
}
