package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-11:15 下午
 */
public class _19_RemoveNthFromEndOffer {


    /**
     * 使用快慢指针解决这个问题
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {


        if (head.next==null) return null;

        //创建一个虚拟头节点

        ListNode dummyNode=new ListNode(-999);

        dummyNode.next=head;

        ListNode fast=dummyNode;//快指针

        ListNode slow=dummyNode;//慢指针

        //先让快指针 先走n+1步

        //-9999  1  2  3  4  5  6  7  //删除倒数第二个

        while (n-->=0){

            fast=fast.next;

        }

        //然后让 fast 和slow 同时走 知道走到 fast=null

        while (fast!=null){

            fast=fast.next;
            slow=slow.next;
        }

        //此时slow所指的节点就是要删除节点的前一个节点

        ListNode del =slow.next;

        slow.next=del.next;

        del.next=null;

        return dummyNode.next;



    }

    /**
     * 先进行遍历链表得到总数,然后在进行遍历得到要删除节点的前一个节点
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {


        //进行特判
        if (head.next==null) return null;

        //创建一个虚拟头节点

        ListNode dummyNode=new ListNode(-999);

        dummyNode.next=head;

        ListNode curr=dummyNode;

        int length=0;//用于计算节点的长度(算上了虚拟节点)
        while (curr!=null){
            curr=curr.next;
            length++;;

        }

        //-9999  1  2  3  4  5  6  7  //删除倒数第二个

        ListNode prve=dummyNode;//找到要删除节点的前一个节点


        for (int i = 0; i <length-n-1 ; i++) {

            prve=prve.next;

        }
        //进行删除倒数第n个节点

        ListNode del=prve.next;//要被删除的节点

        prve.next=del.next;

        del.next=null;
        return dummyNode.next;
    }
}