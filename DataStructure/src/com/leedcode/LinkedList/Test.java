package com.leedcode.LinkedList;

import com.sun.deploy.security.BlacklistedCerts;

/**
 * @author lqw
 * @date 2022/1/19-10:49 上午
 */
public class Test {



    /**
     * 合并k个有序链表--思想和 合并 2个 有序链表类似--运用到归并排序的知识
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {




        return merge(lists,0,lists.length);


    }


    public ListNode merge(ListNode[] lists,int left,int right){

        if (left==right) return lists[left];
        if (left>right) return null;

        int mid=left+(right-left)/2;

        ListNode mergeLeft=merge(lists,left,mid);
        ListNode mergeRight=merge(lists,mid+1,right);
        return mergetTwo(mergeLeft, mergeRight);
    }





    //合并两个有序链表
    public ListNode mergetTwo(ListNode l1,ListNode l2){

        //使用递归法进行对链表合并


        //递归出口

        if (l1==null||l2==null) return l1==null? l2:l1;

        //将大问题化解为小问题

        if (l1.val<l2.val){
            l1.next=mergetTwo(l1.next, l2);

            return l1;

        }else{
            l2.next=mergetTwo(l1, l2.next);
            return l2;
        }
    }

}