package com.leedcode.dayFourteen;


import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/5/9-11:44 上午
 */
public class _160_GetIntersectionNodeTop {


    /**
     * 使用双指针进行求解
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A=headA;

        ListNode B=headB;

        //进行交替 遍历，他俩会在相交的地方相遇,如果没有相交点 则会返回 null
        while (A!=B){
            A=A==null?headB:A.next;

            B=B==null?headA:B.next;
        }


        return A;




    }


    /**
     * 思路一 使用hash表进行求解
     * 时间复杂度:O(m+n)
     *
     * 空间复杂度:O(m+n)
     * * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        Set<ListNode> hash=new HashSet<>();

        while (headA!=null){


            hash.add(headA);

            headA=headA.next;

        }

        while (headB!=null){

            if (hash.contains(headB)) return headB;

            headB=headB.next;


        }


        return null;


    }



}