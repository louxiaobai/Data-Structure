package com.leedcode.dayFourteen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/5/7-12:26 下午
 */
public class _142_DetectCycleOffer {


    /**
     * 快慢指针
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 2(x+y)=x+y+n(y+z)
     * 相遇的时候 差 x 长度就是入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head==null||head.next==null) return null;
        //快慢指针
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast){

                ListNode p=head;

                while (p!=slow){
                    p=p.next;

                    slow=slow.next;
                }

                return slow;

            }

        }
        return null;
    }

    /**
     * hash表存储法--
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {


        if (head==null||head.next==null) return null;


        Set<ListNode> hash= new HashSet<>();


        while (head!=null){

            if (hash.contains(head)) return head;

            hash.add(head);

            head=head.next;


        }

        return null;


    }
}