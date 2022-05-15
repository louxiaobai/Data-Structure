package com.leedcode.twopoint;

import java.util.Arrays;

/**leedcode27����---�Ƴ�Ԫ��
 * @author lqw
 * @date 2021/9/26-3:57 ����
 */
public class RemoveElement {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6};

        System.out.println(removeElement2(arr, 2));

        System.out.println(Arrays.toString(arr));

    }

    /**��ͨ����
     * �����Ƴ������е�Ԫ��
     * @param arr
     * @param val
     */
    public static int removeElement(int[] arr,int val){

        int k=0;

        for (int i = 0; i <arr.length ; i++) {

            if (arr[i]!=val){

                arr[k++]=arr[i];

            }

        }

        return k;
    }


    /**
     * ˫ָ��ⷨ
     * @param arr
     * @param val
     * @return
     */
    public static int removeElement2(int[] arr,int val){
        int slow=0;
        int fast=0;
        //���б�������
        for (int data: arr){
            if (data!=val) {//���data����val��fast++
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }


}