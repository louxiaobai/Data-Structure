package com.leedcode.dayFourteen;


import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/5/7-12:11 下午
 */
public class _141_HasCycleTop {


    /**
     * 使用快慢指针
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        //定于一个快指针 和一个慢指针如果两者出现相遇则说明有环存在


        ListNode slow=head;

        ListNode fast=head;

        while (fast!=null&&fast.next!=null){


            slow=slow.next;

            fast=fast.next.next;

            if (slow==fast) return true;

        }


        return  false;
    }


    /**
     * 使用hash表进行存储
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head){

        //1.进行特殊判断

        if (head.next==null) return false;

        //创建一个hashSet

        Set<ListNode> hash=new HashSet<>();

        while (head!=null){

            if (hash.contains(head)) return true;
            hash.add(head);
            head=head.next;

        }


        return false;


    }
}