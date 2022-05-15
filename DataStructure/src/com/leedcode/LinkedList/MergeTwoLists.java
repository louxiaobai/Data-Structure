package com.leedcode.LinkedList;

/**合并两个有序链表---leedcode 21题
 * @author lqw
 * @date 2021/10/24-10:59 上午
 */
public class MergeTwoLists {

    /**
     *合并两个升序链表--迭代方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        //对特殊情况进行判断
        if (l1==null||l2==null) return l1==null? l2:l1;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (l1!=null&&l2!=null){
            if (l1.val>=l2.val){
                curr.next=l2;
                l2=l2.next;
            }else{
                curr.next=l1;
                l1=l1.next;
            }
            curr=curr.next;

        }

        if (l1!=null){

            curr.next=l1;
        }

        if(l2!=null){

            curr.next=l2;
        }

        return dummy.next;

    }


    /**
     *合并两个升序链表--递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){


        //使用递归法进行对链表合并


        //递归出口

        if (l1==null||l2==null) return l1==null? l2:l1;


        //将大问题化解为小问题

        if (l1.val<l2.val){


            l1.next=mergeTwoLists2(l1.next, l2);

            return l1;

        }else{

            l2.next=mergeTwoLists2(l1, l2.next);

            return l2;

        }




    }







}