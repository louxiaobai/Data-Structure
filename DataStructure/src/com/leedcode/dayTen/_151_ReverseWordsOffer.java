package com.leedcode.dayTen;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/15-10:54 上午
 */
public class _151_ReverseWordsOffer {


    public static void main(String[] args) {
        String str = "the sky is blue";

        System.out.println(reverseWords(str));


    }

    /**
     * 将每个单词进行反转并且不使用额外空间
     * 1.将字符串中多余的空格去掉
     * 2.将全部的字符串进行反转
     * 3.将每个单词的字符串进行反转
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        //1.去掉字符串中多于的空格
        s = removeSpace(s);
        //2.将全部字符进行反转
        char[] chars = s.toCharArray();
        chars = reverse(chars, 0, s.length() - 1);
        //3.将每个空格前的字符进行反转
        s = reverseOne(chars);
        return s;


    }

    public static String reverseOne(char[] chars) {


        int left = 0;

        int n = chars.length;


        while (left < n) {


            if (chars[left] != ' ') {


                int right = left;

                while (right + 1 < n && chars[right + 1] != ' ') right++;

                //right走到了空格处,则对这,这些字符进行反转
                reverse(chars, left, right);
                left = right + 1;

            } else {

                left++;
            }



        }
        return new String(chars);

    }

    public static char[] reverse(char[] chars, int left, int right) {

        while (left < right) {

            char temp = chars[left];

            chars[left] = chars[right];

            chars[right] = temp;

            left++;
            right--;
        }

        return chars;

    }


    public static String removeSpace(String s) {

        char[] chars = s.toCharArray();

        int n=chars.length;

        int slow=0;

        int fast=0;

        while (fast<n){

            while (fast<n&&chars[fast]==' ')fast++;
            while (fast<n&&chars[fast]!=' ')chars[slow++]=chars[fast++];
            while (fast<n&&chars[fast]==' ')fast++;

            if (fast<n) chars[slow++]=' ';//在每个单词的最后面拼接一个空格

        }

        return new String(chars).substring(0,slow);


    }

    /**
     * 使用栈解决问题
     * 思路:先将字符串按照空格进行分割,遍历字符串数组,如果碰见空格则跳出(s1.equal("")) 然后遍历 栈。取出 字符串 进行拼接
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {


        //1.将字符串按照 空格进行分割

        String[] strArr = s.split(" ");


        //创建一个栈

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s1 : strArr) {

            if (s1.equals("")) continue;

            stack.push(s1 + " ");

        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {


            sb.append(stack.pop());

        }

        return sb.toString().trim();

    }




}