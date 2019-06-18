package cn.edu.xd.myy.siliding_window;

/**https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * q19
 * @author myy
 * @date 2019/6/17
 */
public class q19RemoveNthNodeFromEndOfList {
    //设置一个额外的头结点，方便操作。当删除第一个节点，或者链表长度为1时删除节点
    /**
     * 两遍遍历，第一遍获得链表的长度，第二遍移除倒数第n个节点（即length-n+1）个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode index = head;
        while(index!=null){
            length++;
            index=index.next;
        }
        int del=length - n;
        index = dummpy;
        while(del>0){
            del--;
            index = index.next;
        }
        index.next = index.next.next;

        return dummpy.next;
    }

    /**
     * 设置两个指针一遍遍历，两个指针中间相隔n个节点，当快指针走向末尾NULL的时候，慢指针指向要删除节点的前一个节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode first = dummpy;
        ListNode second = dummpy;
        for(int i=1;i<=n+1;i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummpy.next;

    }
}
