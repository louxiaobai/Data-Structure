package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/10-2:05 下午
 */
public class _344_ReverseString {

    /**
     * 对撞指针进行转换
     * 空间复杂度O(1)
     * 时间复杂度O(n/2)
     * @param s
     */
    public void reverseString(char[] s) {

        int left=0;
        int right=s.length-1;
        while (left<=right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }



    }

}