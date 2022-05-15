package com.leedcode.LinkedList;

/**�ϲ�������������---leedcode 21��
 * @author lqw
 * @date 2021/10/24-10:59 ����
 */
public class MergeTwoLists {

    /**
     *�ϲ�������������--������ʽ
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        //��������������ж�
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
     *�ϲ�������������--�ݹ�
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){


        //ʹ�õݹ鷨���ж�����ϲ�


        //�ݹ����

        if (l1==null||l2==null) return l1==null? l2:l1;


        //�������⻯��ΪС����

        if (l1.val<l2.val){


            l1.next=mergeTwoLists2(l1.next, l2);

            return l1;

        }else{

            l2.next=mergeTwoLists2(l1, l2.next);

            return l2;

        }




    }







}