package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-9:05 下午
 */
public class _82_DeleteDuplicates {


    /**
     * 进行删除 重复的元素---阿迭代发
     * 思路:定义一个pre 节点和一个 curr节点,用curr节点进行判断当前节点和curr的下一个节点是否相等,
     * 如果相等则需要进行curr=curr.next;直到当前节点和当前节点的下一个节点不相等
     * 判断不相等后则需要使 pre=curr.next, curr.next=null--释放节点
     * 如果当前节点和当前节点的下一个节点不想等则直接pre=curr
     * 不管是否相等 都需要使 curr=pre.next;
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {


        ListNode dummyNode=new ListNode(-999);
        dummyNode.next=head;
        ListNode pre=dummyNode;
        ListNode curr=head;
        //112233344455567890
        while (curr!=null){
            //如果相同则执行删除操作
            if (curr.next!=null&&curr.val==curr.next.val){
                //因为可能出现多个相同的元素--故需要进行while进行循环删除操作
                 do {
                     curr=curr.next;
                 }while (curr.next!=null&&curr.val==curr.next.val);
                 pre.next=curr.next;
                 //进行释放操作
                 curr.next=null;
            }else{
                pre=curr;
            }
            curr=pre.next;
        }
        return dummyNode.next;

    }
}