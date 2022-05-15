package com.leedcode.LinkedList;

/**删除链表的倒数第 N 个结点,LeedCode-19-中等
 * @author lqw
 * @date 2021/10/21-9:22 上午
 */
public class RemoveNthFromEnd {
    /**
     * 普通解法--两次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            ListNode dummyHead=new ListNode(-1);
            dummyHead.next=head;
            ListNode curr=dummyHead;
            int length=0;
            //计算出链表的长度
            while (curr!=null){
                length++;
                curr=curr.next;
            }
            //找到要删除节点的前一个节点
            ListNode prev=dummyHead;
            for (int i = 1; i <length-n ; i++) {
                  prev=prev.next;
            }
            //进行删除节点
            ListNode delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            //return dummyHead.next;

            return head;
    }


    /**
     * 使用快慢指针进行解答
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;
        //先让快指针走n+1步

        while (n-->=0){

            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //进行删除
        ListNode delNode=slow.next;

        slow.next=delNode.next;

        delNode.next=null;

        return dummyHead.next;

    }


    /**
     * 使用递归进行求解
     * @param head
     * @param n
     * @return
     */
    int cout=0;
    public ListNode removeNthFromEnd3(ListNode head, int n){

        if (head==null)  return head;

        //进行找n的位置

        head.next=removeNthFromEnd3( head.next,n);
        cout++;
        if (cout==n){

            return head.next;
        }
        return head;
    }
}