package com.leedcode.dayFive;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/3/7-8:54 上午
 */
public class _415_AddStrings {

    public static void main(String[] args) {
        String num1="456";
        String num2="77";

        System.out.println(addStrings(num1,num2));


    }

    /**
     * 思路:从字符串的末尾进行进行相加然后存储到StringBuilder 存储后反转
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {


        char[] char1= num1.toCharArray();

        char[] char2 = num2.toCharArray();

        int l1=char1.length-1;
        int l2=char2.length-1;

        StringBuilder sb=new StringBuilder();


        int carry=0;

        while (l1>=0||l2>=0){

            int n1=l1<0? 0:char1[l1]-'0';
            int n2=l2<0? 0:char2[l2]-'0';

            int res=(n1+n2+carry)%10;

            sb.append(res);

            carry=(n1+n2+carry)/10;

            l1--;
            l2--;

        }

        if (carry!=0)  sb.append(carry);


        return sb.reverse().toString();


    }


}