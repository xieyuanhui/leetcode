package cn.edu.xd.myy.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/comments/
 * q108: 将有序数组转换为二叉搜索树
 *
 * 分治加递归实现
 *
 * https://blog.csdn.net/coder__666/article/details/80349039 二叉树遍历递归非递归
 */

public class NumTransToBitree {

    public TreeNode sortedArrayToBST(int[] num){
        if(num == null)
            return null;
        return buildBiTree(num,0,num.length-1);
    }

    //左右等分的建立左右子树，中间节点作为子树的根节点，递归
    public TreeNode buildBiTree(int[] num,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left= buildBiTree(num,left,mid-1);
        root.right=buildBiTree(num,mid+1,right);
        return root;
    }

    //前序遍历
    public void preOrder(TreeNode t){
        if(t!= null){
            System.out.print(t.val+" ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    //非递归前序遍历,利用栈存储父节点的信息
    public void preOrder_Non(TreeNode t){
        Stack<TreeNode> stack = new Stack<>();

        while(t!=null || !stack.isEmpty()){
            while(t!=null){
                System.out.print(t.val +" ");
                stack.push(t);
                t=t.left;
            }
            if(!stack.isEmpty()){
                t=stack.pop();
                t=t.right;
            }

        }

    }

    //中序遍历
    public void midOrder(TreeNode t){
        if(t != null){
            midOrder(t.left);
            System.out.print(t.val +" ");
            midOrder(t.right);
        }
    }

    //非递归中序遍历，与前序遍历类似，利用栈存储父节点的信息
    public void midOrder_Non(TreeNode t){
        Stack<TreeNode> stack = new Stack<>();
        while(t!=null || !stack.isEmpty()){
            while(t!=null){
                stack.push(t);
                t=t.left;
            }
            if(!stack.isEmpty()){
                t=stack.pop();
                System.out.print(t.val+" ");
                t=t.right;
            }
        }
    }

    //后序遍历
    public void postOrder(TreeNode t){
        if(t!=null){
            postOrder(t.left);
            postOrder(t.right);
            System.out.print(t.val +" ");
        }
    }

    //非递归后续遍历,由于后续遍历先遍历左右节点，在遍历根节点；在非递归算法的时候，利用栈退回的时候，不清楚是从左子树退出还是从右子树退出，
    //如果是从左子树退出，则需要访问右子树；如果从右子树退出，则需要访问根节点。
    //所以多建立一个辅助栈用于存储 左右孩子的信息
    public void postOrder_Non(TreeNode t){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int left = 1;
        int right = 2;

        while(t != null || !stack1.isEmpty()){
            while(t!=null){
                //将节点压入栈1，并在栈2中记录节点标记为左节点
                stack1.push(t);
                stack2.push(left);
                t=t.left;
            }
            while(!stack1.isEmpty() && stack2.peek() == right){
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.print(stack1.pop().val +" ");
            }
            if(!stack1.isEmpty() && stack2.peek() == left){
                //如果是从左子节点返回父节点，则将标记该为右子节点
                stack2.pop();
                stack2.add(right);
                t = stack1.peek().right;
            }
        }

    }

    //层序遍历
    public void levelOrder(TreeNode t){
        //利用队列实现
        //对于不为空的节点，先把节点加入到队列中，
        //从队中拿出结点，如果节点的左右节点不为空，就分别吧节点加入到队列中
        Queue<TreeNode> queue = new LinkedList<>();
        if(t == null)
            return;
        queue.add(t);
        TreeNode curNode;
        while(!queue.isEmpty()){
            curNode = queue.poll();
            System.out.print(curNode.val+" ");
            if(curNode.left!=null)
                queue.add(curNode.left);
            if(curNode.right!=null)
                queue.add(curNode.right);
        }
    }

    public static void main(String[] args){
        NumTransToBitree ntb = new NumTransToBitree();
        int[] num = {-10,-3,0,5,9};
        TreeNode t = ntb.sortedArrayToBST(num);
        System.out.println("---前序遍历");
        ntb.preOrder(t);
        System.out.println();

        System.out.println("---非递归前序遍历");
        ntb.preOrder_Non(t);
        System.out.println();

        System.out.println("---中序遍历");
        ntb.midOrder(t);
        System.out.println();

        System.out.println("---非递归中序遍历");
        ntb.midOrder_Non(t);
        System.out.println();

        System.out.println("---后序遍历");
        ntb.postOrder(t);
        System.out.println();

        System.out.println("---非递归后序遍历");
        ntb.postOrder_Non(t);
        System.out.println();

        System.out.println("---层序遍历");
        ntb.levelOrder(t);
        System.out.println();

    }

}

