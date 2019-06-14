package cn.edu.xd.myy.LinkedList;
/*
* https://leetcode.com/problems/merge-two-sorted-lists/
* 合并两个排序的链表
* */
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode currA, ListNode currB) {
        if(currA == null)
            return currB;
        if(currB==null)
            return currA;
        ListNode res = new ListNode(0);
        ListNode result = res;
        while(currA != null && currB != null){
            if(currA.val <= currB.val){
                result.next= currA;
                result = result.next;
                currA=currA.next;
            }else{
                result.next = currB;
                result = result.next;
                currB=currB.next;
            }
        }
        if (currA!=null){
            result.next = currA;
        }
        if(currB!=null){
        result.next = currB;
        }
        return res.next;
    }

}
