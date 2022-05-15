package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/12-10:29 上午
 */
public class _23_MergeKListsOffer {


    /**
     * 使用归并排序
     * 空间复杂度:O((n*k)Logk)
     * 空间复杂度:O(logk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {



        //进行特殊判断
        if (lists==null||lists.length==0) return null;
        if (lists.length==1) return lists[0];
        if (lists.length==2) return mergeTwoLists(lists[0],lists[1]);


        return mergeList(lists,0,lists.length-1);

    }


    public ListNode mergeList(ListNode[] lists,int left,int right){

        if (left>right) return null;


        if (left==right) return lists[left];//不需要进行合并了直接进行返回即可


        int mid=left+(right-left)/2;

        //对数组的左半部分进行合并

        ListNode listLeft = mergeList(lists, left, mid);

        //对数组的右半部分进行合并

        ListNode listRight = mergeList(lists, mid+1, right);


        return mergeTwoLists(listLeft,listRight);


    }






    /**
     * 迭代求解--逐个合并有序链表
     *
     * 第一次合并:合并后链表的长度为2n
     * 第二次合并:合并后链表的长度为3n
     * ............................
     * 第i次合并的时间复杂度:合并和链表的的长度为(i+1)*n
     *
     * 时间复杂度:O(k^2n)
     * 空间复杂度:O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {


        //进行特殊判断
        if (lists==null||lists.length==0) return null;
        if (lists.length==1) return lists[0];
        if (lists.length==2) return mergeTwoLists(lists[0],lists[1]);
        ListNode listNode = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length ; i++) {

            listNode=mergeTwoLists(listNode, lists[i]);

        }

        return listNode;


    }


    /**
     * 时间复杂度:O(m+n)
     * 空间复杂度:O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {



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