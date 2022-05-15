package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-8:55 下午
 */
public class _89_DeleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode=new ListNode(-101);
        dummyNode.next=head;
        ListNode cur=dummyNode;
        while (cur.next!=null){
            if (cur.val==cur.next.val){//说明节点元素重复需要进行删除操作
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return dummyNode.next;

    }
}