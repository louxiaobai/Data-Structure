package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/3-4:37 下午
 */
public class _557_ReverseWords {


    /**
     * 思路:将字符串按照空格进行分割 然后 使用对撞指针交换单词顺序
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        String[] strs= s.split(" ");

        String s1="";

        for (int i = 0; i <strs.length ; i++) {

            char[] chars = strs[i].toCharArray();

            int left=0;

            int right=chars.length-1;

            while (left<right){

                char temp=chars[left];

                chars[left]=chars[right];

                chars[right]=temp;

                left++;

                right--;
            }

            if (i==strs.length-1){

                s1+=new String(chars);

            }else {

                s1+=new String(chars)+" ";

            }


        }

        return s1;

    }


}