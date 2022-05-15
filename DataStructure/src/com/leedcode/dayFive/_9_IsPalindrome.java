package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/6-11:37 上午
 */
public class _9_IsPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
    }



    public static boolean isPalindrome(int x) {


        if (x<0)return false;

        int sum=0;
        int y=x;
        while (y!=0){

            int pop=y%10;//取到数字的个位数

            y=y/10;//去掉最后一位个位数字

            int res=sum*10+pop;

            sum=res;

        }

        return x==sum;

    }


}