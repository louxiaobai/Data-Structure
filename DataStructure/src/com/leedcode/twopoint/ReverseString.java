package com.leedcode.twopoint;

/**��ת�ַ���--˫ָ��֮ⷨ��ײָ��
 * @author lqw
 * @date 2021/9/24-3:07 ����
 */
public class ReverseString {


    public static void main(String[] args) {

        System.out.println( reverseString("hello"));
    }

    /**
     * ��ײָ��
     * @param str
     */
    public static  String reverseString(String str){

        //���ַ���ת�����ַ�����
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