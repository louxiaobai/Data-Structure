package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/8-11:20 上午
 */
public class _61_RotateRight {

    public static void main(String[] args) {

        System.out.println(4%3);
        System.out.println(4%12);

    }

    /**
     * 思路:先将全部进行反转,然后将前k个进行反转,在将k之后的进行反转 连接起来
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        //进行特殊判断
        if (head==null||head.next==null) return head;

        //求出链表的全部长度

        int lenth=0;

        ListNode lenNode=head;

        while (lenNode!=null){

            lenNode=lenNode.next;
            lenth++;
        }

        //进行判断k是否为 length的整数倍 如果为整数倍则不需要进行反转了

        if (k%lenth==0) return head;

        k=k%lenth;//实际需要进行移动的


        //将全部链表进行反转

        ListNode newHead=reverse(head);

        //找到前k个节点

        ListNode nodeK=newHead;

        for (int i = 0; i <k-1; i++) {

            nodeK=nodeK.next;

        }

        //第k+1个节点

        ListNode nextNode=nodeK.next;

        //将前k个链表节点和后面的节点进行断开

        nodeK.next=null;

        //将前k个节点进行反转

        ListNode reHead=reverse(newHead);

        //将后k后的节点进行反转,然后进行拼接

        newHead.next=reverse(nextNode);

        return reHead;

    }

    /**
     * 对链表进行反转
     * @param head
     */
    public  ListNode reverse(ListNode head){

        ListNode pre=null;

        ListNode curr=head;

        ListNode temp=null;

        while (curr!=null){

            temp=curr.next;

            curr.next=pre;

            pre=curr;

            curr=temp;

        }

        return pre;

    }

}