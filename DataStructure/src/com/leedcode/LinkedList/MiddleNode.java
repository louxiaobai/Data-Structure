package com.leedcode.LinkedList;

import com.line.quequ.LinkedQueue;
import sun.util.resources.cldr.ebu.CurrencyNames_ebu;
import sun.util.resources.cldr.sn.LocaleNames_sn;

/**������м���-leedcode 876 ��
 * @author lqw
 * @date 2021/10/21-8:58 ����
 */
public class MiddleNode {

    public static void main(String[] args) {

    }

    /**
     * ����ѭ����
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        if (head==null) return null;

        int length=0;

        //�õ�����ĳ���
        ListNode tmp=head;
        while (tmp!=null){
            length++;
            tmp=tmp.next;
        }

        //�����м�ڵ�

        for (int i = 0; i <length/2 ; i++) {

              head=head.next;


        }

        return  head;



    }


    /**
     * ����ָ��
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head){


        ListNode slow=head;//������ָ��

        ListNode fast=head;//�����ָ��

        while (fast!=null&&fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;


        }

        return slow;



    }




}