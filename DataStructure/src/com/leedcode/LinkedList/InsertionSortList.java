package com.leedcode.LinkedList;
import com.line.quequ.LinkedQueue;
import javax.swing.*;
import java.util.Arrays;
/**
 * @author lqw
 * @date 2021/10/26-11:30 上午
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

        while (curr!=null){//如果curr不为null 则一直执行下去

            if (prev.val<=curr.val){

                prev=curr;
                curr=curr.next;

            }else{

                //设置一个p节点 用来寻找第一个比curr的值的大点
                ListNode p=dummyNode;
                while (p.next!=null&&p.next.val<curr.val){

                    p=p.next;

                }

                //找到第一个比curr值大的点则进行交换操作

                prev.next=curr.next;
                curr.next=p.next;
                p.next=curr;
                curr=prev.next;

            }


        }


        return dummyNode.next;
    }


}