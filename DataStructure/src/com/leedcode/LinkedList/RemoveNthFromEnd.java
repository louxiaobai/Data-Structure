package com.leedcode.LinkedList;

/**ɾ������ĵ����� N �����,LeedCode-19-�е�
 * @author lqw
 * @date 2021/10/21-9:22 ����
 */
public class RemoveNthFromEnd {
    /**
     * ��ͨ�ⷨ--���α���
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
            //���������ĳ���
            while (curr!=null){
                length++;
                curr=curr.next;
            }
            //�ҵ�Ҫɾ���ڵ��ǰһ���ڵ�
            ListNode prev=dummyHead;
            for (int i = 1; i <length-n ; i++) {
                  prev=prev.next;
            }
            //����ɾ���ڵ�
            ListNode delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            //return dummyHead.next;

            return head;
    }


    /**
     * ʹ�ÿ���ָ����н��
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;
        //���ÿ�ָ����n+1��

        while (n-->=0){

            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //����ɾ��
        ListNode delNode=slow.next;

        slow.next=delNode.next;

        delNode.next=null;

        return dummyHead.next;

    }


    /**
     * ʹ�õݹ�������
     * @param head
     * @param n
     * @return
     */
    int cout=0;
    public ListNode removeNthFromEnd3(ListNode head, int n){

        if (head==null)  return head;

        //������n��λ��

        head.next=removeNthFromEnd3( head.next,n);
        cout++;
        if (cout==n){

            return head.next;
        }
        return head;
    }
}