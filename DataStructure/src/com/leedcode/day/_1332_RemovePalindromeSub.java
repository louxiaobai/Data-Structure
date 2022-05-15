package com.leedcode.day;

/**
 * @author lqw
 * @date 2022/1/22-9:07 下午
 */
public class _1332_RemovePalindromeSub {


    /**
     * 双指针解法
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {


        char[] c=s.toCharArray();

        int left=0;
        int right=c.length-1;

        while (left<=right){

            if (c[left]!=c[right]){

                return 2;
            }else {

                left++;
                right--;
            }

        }



        return 1;


    }

}