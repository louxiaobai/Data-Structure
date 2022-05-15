package com.leedcode.twopoint;

import java.util.Arrays;

/**˫ָ���㷨--����ָ��
 * @author lqw
 * @date 2021/9/24-9:12 ����
 */
public class MoveZeroes {


    public static void main(String[] args) {

        int[] arr=new int[]{1,0,2,0,3,1,0};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * ˫ָ��ⷨ
     * @param arr
     */

    public  static  void  moveZeroes(int[] arr){

        if (arr==null||arr.length==0){

            return;
        }

        int slow=0;

        for (int fast=0;fast<arr.length;fast++){

            if (fast==slow){//���ٽ�������
                continue;
            }
            if (arr[fast]!=0){
                //���п���ָ�뽻��
                int tmp=arr[fast];
                arr[fast]=arr[slow];
                arr[slow]=tmp;

                slow++;

            }

        }

    }

    public  static  void  moveZeroes2(int[] arr){

        if (arr==null||arr.length==0){

            return;
        }

        int slow=0;

        for (int fast=0;fast<arr.length;fast++){

            if (fast==slow){//���ٽ�������
                continue;
            }
            if (arr[fast]!=0){
                 //���и��Ʋ������ٽ�������

                 arr[slow]=arr[fast];
                slow++;

            }

        }

        for (;slow<arr.length;slow++){

            arr[slow]=0;

        }

    }





}