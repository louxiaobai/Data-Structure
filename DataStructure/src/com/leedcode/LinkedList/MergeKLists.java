package com.leedcode.LinkedList;

import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SSPublic;
import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.util.Comparator;
import java.util.PriorityQueue;

/**�ϲ�K����������-leedcode23 ����
 * @author lqw
 * @date 2021/10/24-11:46 ����
 */
public class MergeKLists {


    public static void main(String[] args) {
    }
    /**
     * ˳��ϲ�--���������ϲ�
     * ʱ�临�Ӷ�:O(K^2 * n)
     * �ռ临�Ӷ�O(1)
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
        //����һ������ڵ�
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
     * �鲢�ϲ�--����˼��
     * ʱ�临�Ӷ�ΪO(k*n*logk)
     * �ռ临�Ӷ�ΪO(logk)
     * * @param lists
     * @return
     */

    public static ListNode mergeKLists2(ListNode[] lists){

        if (lists==null||lists.length==0) return null;

        return merge(lists, 0, lists.length-1);


    }


    public static ListNode merge(ListNode[] listNodes,int left,int right){

         //�ݹ����
         if (left==right) return listNodes[left];
         if (left>right) return null;
         int mid=left+(right-left)/2;
         //����벿�ֽ��кϲ�
         ListNode mergeLeftList=merge(listNodes,left,mid);
         //���Ұ벿�ֽ��кϲ�
         ListNode mergeRightList=merge(listNodes,mid+1,right);
         return mergeTwoLists(mergeLeftList,mergeRightList);

    }

    /**
     * �ϲ�k����������(���ȶ���)
     * ʱ�临�Ӷ�(k*n*logk)
     * �ռ临�Ӷ�:O(logk) k Ϊ������  nΪû������ĳ���
     * @param lists
     * @return
     */
    public ListNode mergeTwoLists3(ListNode[] lists){

        //lambda���ʽ
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        //1.�������ȫ��ͷ�ڵ���� С������

        for (ListNode list : lists) {
            pq.offer(list);
        }
        //����һ������ͷ�ڵ�
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