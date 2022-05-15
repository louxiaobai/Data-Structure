package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/2-9:26 下午
 */
public class _344_ReverseString {


    /**
     * 思路:双指针 对撞指针
     * 时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param s
     */
    public void reverseString(char[] s) {

        if (s==null) return;

        int i=0;
        int j=s.length-1;
        while (i<j){

            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }




    }

}