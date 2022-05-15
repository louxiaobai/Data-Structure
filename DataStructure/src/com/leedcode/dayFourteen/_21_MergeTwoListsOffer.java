package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/9-3:31 下午
 */
public class _21_MergeTwoListsOffer {


    /**
     * 递归做法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        //递归出口
        if (list1==null||list2==null) return list1==null?list2:list1;

        //大问题化成小问题

        if (list1.val<list2.val){
            list1.next=mergeTwoLists1(list1.next, list2);
            return list1;

        }else {
            list2.next=mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代做法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {


        ListNode dummyNode=new ListNode(-1);

        ListNode curr=dummyNode;

        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else {
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }


        if (list1!=null) curr.next=list1;

        if (list2!=null) curr.next=list2;

        return dummyNode.next;

    }


}