package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-10:42 下午
 */
public class _876_MiddleNode {
    
    /**
     * 快慢指针问题
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //进行特判
        if(head==null||head.next==null) return head;
        ListNode slow=head;//定义慢指针
        ListNode fast=head;//定义快指针
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}