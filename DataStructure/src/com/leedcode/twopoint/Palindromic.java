package com.leedcode.twopoint;

import java.util.Arrays;

/**�����ַ���--˫ָ��ⷨ
 * @author lqw
 * @date 2021/9/24-3:31 ����
 */
public class Palindromic {


    public static void main(String[] args) {

        boolean flag=isPalindromic("A man, a plan, a canal: Panama");

        if (flag){

            System.out.println("�ǵ�");
        }else{

            System.out.println("����");
        }
    }

    /**
     * �����ж��ַ����Ƿ�Ϊ�����ַ���
     * @param str
     * @return
     */
    public static boolean isPalindromic(String str){

        char[] arr=str.toCharArray();

        System.out.println(Arrays.toString(arr));

        int left=0;

        int right=arr.length-1;

        while (left<right){//����ѭ��������

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