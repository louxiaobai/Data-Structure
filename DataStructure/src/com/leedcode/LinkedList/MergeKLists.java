package com.leedcode.LinkedList;

import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SSPublic;
import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.util.Comparator;
import java.util.PriorityQueue;

/**合并K个升序链表-leedcode23 困难
 * @author lqw
 * @date 2021/10/24-11:46 上午
 */
public class MergeKLists {


    public static void main(String[] args) {
    }
    /**
     * 顺序合并--基于两两合并
     * 时间复杂度:O(K^2 * n)
     * 空间复杂度O(1)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length==0) return null ;
        if (lists.length==1) return lists[0];
        ListNode outputList=lists[0];
        for (int i = 1; i <lists.length ; i++) {
            outputList=mergeTwoLists(outputList, lists[i]);
        }
        return outputList;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1==null||l2==null) return l1==null? l2: l1;
        //设置一个虚拟节点
        ListNode dummyNode=new ListNode(-1);
        ListNode curr=dummyNode;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                curr.next=l1;
                curr=curr.next;
                l1=l1.next;
            }else {
                curr.next=l2;
                curr=curr.next;
                l2=l2.next;
            }
        }
        if (l1==null){
            curr.next=l2;
        }
        if (l2==null){
            curr.next=l1;
        }
        return dummyNode.next;
    }

    /**
     * 归并合并--分治思想
     * 时间复杂度为O(k*n*logk)
     * 空间复杂度为O(logk)
     * * @param lists
     * @return
     */

    public static ListNode mergeKLists2(ListNode[] lists){

        if (lists==null||lists.length==0) return null;

        return merge(lists, 0, lists.length-1);


    }


    public static ListNode merge(ListNode[] listNodes,int left,int right){

         //递归出口
         if (left==right) return listNodes[left];
         if (left>right) return null;
         int mid=left+(right-left)/2;
         //对左半部分进行合并
         ListNode mergeLeftList=merge(listNodes,left,mid);
         //对右半部分进行合并
         ListNode mergeRightList=merge(listNodes,mid+1,right);
         return mergeTwoLists(mergeLeftList,mergeRightList);

    }

    /**
     * 合并k个升序链表(优先队列)
     * 时间复杂度(k*n*logk)
     * 空间复杂度:O(logk) k 为链表长度  n为没个链表的长度
     * @param lists
     * @return
     */
    public ListNode mergeTwoLists3(ListNode[] lists){

        //lambda表达式
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        //1.将链表的全部头节点放入 小根堆中

        for (ListNode list : lists) {
            pq.offer(list);
        }
        //定义一个虚拟头节点
        ListNode dummyNode=new ListNode(-1);
        ListNode curr=dummyNode;
        //O(kn*logk)
        while (!pq.isEmpty()){//O(Kn)

            ListNode minNode=pq.remove();//O(logk)

            curr.next=minNode;

            curr=curr.next;

            if (minNode.next!=null){
                pq.offer(minNode.next);//O(logk)
            }
        }
        return dummyNode.next;
    }

}