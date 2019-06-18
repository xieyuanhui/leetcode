package cn.edu.xd.myy.heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * q23 合并k个排序的列表
 * @author myy
 * @date 2019/6/17
 */
public class q23MergeKSortedLists {
    /**
     * 暴力法求解，将k个链表的值存入一个ArrayList中，然后对list排序，构造排序后的链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <=0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode head = lists[i];
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(list);
        ListNode dump = new ListNode(-1);
        ListNode index = dump;
        for(int i=0;i<list.size();i++){
            ListNode node = new ListNode(list.get(i));
            index.next = node;
            index = node;
        }
        return dump.next;

    }

    /**
     * 方法二，归并排序的思想，合并两两list
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length <=0){
            return null;
        }
        int begin =0;
        int end = lists.length-1;
        while(begin < end){
            int mid = begin +(end-begin)/2;
            for(int i=0;i<=mid;i++){
                lists[i] = mergeList(lists[i],lists[end-i]);
            }
            end = (begin+end)/2;
        }
         return lists[0];
    }
    public ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null && l2 == null) return null;
        if(l1==null) return l2;
        if(l2 == null) return l1;

        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur =l1;
                l1=l1.next;
            }else{
                cur.next = l2;
                cur = l2;
                l2=l2.next;
            }
        }
        if(l1!= null){ cur.next = l1;}
        if(l2!=null){cur.next = l2;}
        return dump.next;
    }
}
