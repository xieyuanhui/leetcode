package cn.edu.xd.myy.LinkedList;

import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * q138: 含有随机指针的链表的复制
 */
class Node{
    public int val;
    public Node next;
    public Node random;
    public Node(){}
    public Node(int _val,Node _next,Node _random){
        val=_val;
        next=_next;
        random=_random;
    }
}
public class RondomPoniterListCopy {
//    //利用hashMap, map 中存储原链表中节点和新链表节点的配对信息<N,N'>
//    public Node copyRandomList(Node head) {
//        HashMap<Node,Node> map = new HashMap<>();
//        Node cur = head;
//        while(cur!= null){
//            map.put(cur,new Node(cur.val,cur.next,cur.random));//初始的 next，random是原链表中的值，需要在后面进行修改
//            cur = cur.next;
//        }
//
//        cur=head;
//        while(cur!=null){
//            map.get(cur).next = map.get(cur.next);
//            cur= cur.next;
//        }
//        cur =head;
//        while(cur!=null){
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        Node reNode = map.get(head);
//        return reNode;
//    }

    //剑指offer上的解法
    /**
     * 主要分为三个步骤：
     * 第一步：根据原始链表的每个节点N创建对应的N',并把N'连接在N的后面
     * 第二步:设置复制出来的节点的random。原始链表上N的random指向s,那么其复制出来的N‘是N 的next指向的节点，同样s'是s的next指向的节点
     * 第三步是把这个长链表拆分成两个链表，奇数位置用next连接起来就是原链表，偶数位置用next连接起来就是新链表
     */

    public Node copyRandomList(Node head) {
        copyNodes(head);
        connectRandomNodes(head);
        return ReconnectNodes(head);
    }
    public void copyNodes(Node head){
        Node pNode = head;
        while(pNode!=null){
            Node pClone = new Node();
            pClone.val=pNode.val;
            pClone.next=pNode.next;
            pClone.random= null;
            pNode.next = pClone;

            pNode = pClone.next;
        }
    }
    public void connectRandomNodes(Node head){
        Node pNode = head;
        while(pNode!=null){
            Node pClone = pNode.next;
            if(pNode.random!=null){
                pClone.random=pNode.random.next;
            }
            pNode=pClone.next;
        }

    }
    public Node ReconnectNodes(Node head){
        Node pNode = head;
        Node pCloneHead = null;
        Node pCloneNode = null;
        if(pNode!=null){
            pCloneHead=pNode.next;
            pCloneNode=pCloneHead;
            pNode.next=pCloneNode.next;
            pNode = pNode.next;
        }
        //注意需要在前面if语句中进行一次 指针的转换，否则下面的while循环会造成空指针异常
        while(pNode!=null){
            pCloneNode.next=pNode.next;
            pCloneNode=pCloneNode.next;
            pNode.next=pCloneNode.next;
            pNode=pNode.next;
        }
        return pCloneHead;
    }
}
