package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/9-10:55 上午
 */
public class _234_IsPalindromeTop {


    /**
     *  将链表分为两半 然后将后半段进行反转 然后比较值是否是相等的
     *  注意奇数偶数的问题-如果链表是奇数需要将 slow 指针多向前面移动一位
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {


        ListNode fast=head;

        ListNode slow=head;

        //通过快慢指针找到链表的中点 12345
        while (fast!=null&&fast.next!=null){

            fast=fast.next.next;
            slow=slow.next;
        }

        //需要进行再次判断--如果是奇数个节点 需要将 slow 往后在次移动一位

        if (fast!=null){
            slow=slow.next;
        }

        //将后半段进行反转操作

        ListNode reverse=reverse(slow);

        while (reverse!=null){

            if (head.val!=slow.val) return false;

            head=head.next;
            slow=slow.next;

        }

        return true;

    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){


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