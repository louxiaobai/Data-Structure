package com.leedcode.LinkedList;

/** �Ƴ�����Ԫ��--leedcode 203 �� ��
 * @author lqw
 * @date 2021/10/20-10:32 ����
 */
public class RemoveElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {

        if (head==null) return null;

        ListNode dummyHead=new ListNode(0);//����һ������ͷ�ڵ�
        dummyHead.next=head;
        ListNode cur=dummyHead;

        while (cur!=null){

            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else {

                cur=cur.next;
            }

        }

        return dummyHead.next;
    }
}