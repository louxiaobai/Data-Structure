package com.leedcode.LinkedList;
import com.line.quequ.LinkedQueue;
import javax.swing.*;
import java.util.Arrays;
/**
 * @author lqw
 * @date 2021/10/26-11:30 ����
 */
public class InsertionSortList {

    public static void main(String[] args) {

    }
    public ListNode insertionSortList(ListNode head) {

        if (head==null||head.next==null) return head;
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode curr=head.next;
        ListNode prev=head;

        while (curr!=null){//���curr��Ϊnull ��һֱִ����ȥ

            if (prev.val<=curr.val){

                prev=curr;
                curr=curr.next;

            }else{

                //����һ��p�ڵ� ����Ѱ�ҵ�һ����curr��ֵ�Ĵ��
                ListNode p=dummyNode;
                while (p.next!=null&&p.next.val<curr.val){

                    p=p.next;

                }

                //�ҵ���һ����currֵ��ĵ�����н�������

                prev.next=curr.next;
                curr.next=p.next;
                p.next=curr;
                curr=prev.next;

            }


        }


        return dummyNode.next;
    }


}