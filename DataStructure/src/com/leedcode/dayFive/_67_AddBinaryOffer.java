package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/7-10:27 上午
 */
public class _67_AddBinaryOffer {

    public static void main(String[] args) {

        System.out.println(addBinary("1010", "1011"));

    }


    public static String addBinary(String a, String b) {

        int l1=a.length()-1;

        int l2=b.length()-1;

        StringBuilder sb=new StringBuilder();

        int carry=0;

        while (l1>=0||l2>=0){

            int num1=l1<0?0:a.charAt(l1)-'0';
            int num2=l2<0?0:b.charAt(l2)-'0';

            int sum=num1+num2+carry;

            sb.append(sum%2);

            carry=sum/2;

            l1--;
            l2--;

        }

        if (carry!=0) sb.append(carry);

        return sb.reverse().toString();



    }


}