package cn.edu.xd.myy.LinkedList;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * q234 回文链表
 *
 */
public class PalindromeList {
    /**
     * 利用fast slow指针找到栈的中间节点
     * 然后利用栈 将前半段 入栈
     * 出栈时与 链表的后半段比较是否相等，相等则是回文，否则不是回文
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        if(head == null || head.next == null)
            return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!= null){
            stack.push(slow);
            slow = slow.next;
            fast= fast.next.next;
        }
        if(fast!= null){
            //链表是奇数
            slow =  slow.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().val!=slow.val){
                return false;
            }
            slow =slow.next;
        }
        return true;

    }

    /**
     * 不利用栈实现
     * 将后半段链表反转 与前半段链表相比
     */
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            //奇数
            slow= slow.next;
        }

        //链表反转
        ListNode reverseHead = null;
        ListNode pNode = slow;
        ListNode pre =null;
        while(pNode!=null){
            ListNode pNext = pNode.next;
            if(pNext == null){
                reverseHead = pNode;
            }
            pNode.next = pre;
            pre = pNode;
            pNode=pNext;
        }

        while(reverseHead!=null){
            if(reverseHead.val != head.val){
                return false;
            }
            reverseHead=reverseHead.next;
            head = head.next;
        }
        return true;

    }

}
