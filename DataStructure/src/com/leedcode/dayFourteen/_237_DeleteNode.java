package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-8:39 下午
 */
public class _237_DeleteNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

}