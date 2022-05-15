package com.leedcode.twopoint;

import java.util.Arrays;

/**回文字符串--双指针解法
 * @author lqw
 * @date 2021/9/24-3:31 下午
 */
public class Palindromic {


    public static void main(String[] args) {

        boolean flag=isPalindromic("A man, a plan, a canal: Panama");

        if (flag){

            System.out.println("是的");
        }else{

            System.out.println("不是");
        }
    }

    /**
     * 进行判断字符串是否为回文字符换
     * @param str
     * @return
     */
    public static boolean isPalindromic(String str){

        char[] arr=str.toCharArray();

        System.out.println(Arrays.toString(arr));

        int left=0;

        int right=arr.length-1;

        while (left<right){//进行循环的条件

            while (left<right&&!Character.isLetterOrDigit(arr[left])){

                left++;

            }
            while (left<right&&!Character.isLetterOrDigit(arr[right])){

                right--;
            }
            if (left<right){

                if (Character.toLowerCase(arr[left])!=Character.toLowerCase(arr[right])){

                        return false;
                }
                left++;
                right--;

            }
        }
        return true;
    }

}