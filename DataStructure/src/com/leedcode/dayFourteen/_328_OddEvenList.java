package com.leedcode.dayFourteen;

import org.hamcrest.core.Is;

/**
 * @author lqw
 * @date 2022/5/8-3:27 下午
 */
public class _328_OddEvenList {


    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        //进行特殊判断
        if (head==null||head.next==null||head.next.next==null) return head;

        ListNode odd=head;

        ListNode even=head.next;

        ListNode evenHead=even;

        while (even!=null&&even.next!=null){

            odd.next=even.next;

            odd=odd.next;

            even.next=odd.next;

            even=even.next;

        }

        odd.next=evenHead;

        return head;

    }

}
