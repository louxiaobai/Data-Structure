package com.leedcode.LinkedList;

import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

import java.util.List;

/**��ת���� leedcode 206   ��
 * @author lqw
 * @date 2021/10/20-10:53 ����
 */
public class ReverseList {

    public static void main(String[] args) {

    }

    /**
     * ������
     * @param head
     * @return
     */
    public  ListNode reverseList01 (ListNode head) {

        if (head==null) return null;
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=null;
        while (curr.next!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

        }
        return prev;

    }
    /**
     * �ݹ�ⷨ
     * @param head
     * @return
     */
    public  ListNode reverseList02 (ListNode head) {
        if (head==null||head.next==null) return head;//�ݹ��������
        ListNode p=reverseList02(head.next);//�ݵĹ���
        //���з�ת����
        head.next.next=head;
        head.next=null;
        return p;
    }
}