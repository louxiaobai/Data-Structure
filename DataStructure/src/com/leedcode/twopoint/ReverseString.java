package com.leedcode.twopoint;

/**反转字符串--双指针解法之对撞指针
 * @author lqw
 * @date 2021/9/24-3:07 下午
 */
public class ReverseString {


    public static void main(String[] args) {

        System.out.println( reverseString("hello"));
    }

    /**
     * 对撞指针
     * @param str
     */
    public static  String reverseString(String str){

        //将字符串转换成字符数组
        char[] arr=str.toCharArray();

        int left=0;
        int right=str.length()-1;

       while (left<right){
              char temp=arr[left];
              arr[left]=arr[right];
              arr[right]=temp;
              left++;
              right--;
        }
        return new String(arr);

    }

}