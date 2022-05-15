package com.leedcode.offer;

import java.util.Arrays;

/**��ָoffer45���㷨��-�е�
 * @author lqw
 * @date 2021/10/6-11:01 ����
 */
public class MinNumber {


    public static void main(String[] args) {

        int[] data=new int[]{1,2,3,45,6,7,831,23,1,2,23};
        System.out.println(minNumber(data));
    }


    /**
     * ʵ����С��
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {

        sort(nums, 0, nums.length-1);

        //��������ַ���

        StringBuilder sb=new StringBuilder();

        for (int num : nums) {

            sb.append(num);

        }

        return sb.toString();

    }


    /**
     * ʹ�ÿ��� ��������
     * @param data
     * @param lo
     * @param hi
     */
    public static void sort(int[] data,int lo,int hi){

        if (lo>=hi) return;//�ݹ��������

        //��������

        int left=lo;
        int right=hi;
        int pivot=data[right];
        int index=left;

        while (index<=right){

            String xy=data[index]+""+pivot;
            String yx=pivot+""+data[index];

            if (xy.compareTo(yx)<0){
                int temp=data[left];
                data[left]=data[index];
                data[index]=temp;
                left++;
                index++;
            } else if (xy.compareTo(yx)>0){
                int temp=data[right];
                data[right]=data[index];
                data[index]=temp;
                right--;
            }else{

                index++;
            }
        }

        sort(data, lo, left-1);
        sort(data, right+1, hi);



    }




}