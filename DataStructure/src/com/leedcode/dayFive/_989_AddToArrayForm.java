package com.leedcode.dayFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lqw
 * @date 2022/3/6-12:03 下午
 */
public class _989_AddToArrayForm {

    public static void main(String[] args) {

        System.out.println(addToArrayForm(new int[]{1}, 33));

    }

    /**
     * 思路:从后往前进行相加 注意边界问题:
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param num
     * @param k
     * @return
     */
    public static List<Integer> addToArrayForm(int[] num, int k) {


        int length=num.length-1;

        int carry=0;//用来标识进位数

        List<Integer> list=new ArrayList<>();


        while (length>=0||k!=0){

            int num1=length>=0? num[length]:0;
            int num2=k%10;

            k=k/10;
            list.add((num1+num2+carry)%10);

            carry=(num1+num2+carry)/10;

            length--;

        }

        if (carry!=0) list.add(carry);
//        Collections.reverse(list);//将数组进行反转
        return list;
    }

}