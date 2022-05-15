package com.leedcode.offer;

import java.util.Arrays;

/**剑指offer45号算法题-中等
 * @author lqw
 * @date 2021/10/6-11:01 上午
 */
public class MinNumber {


    public static void main(String[] args) {

        int[] data=new int[]{1,2,3,45,6,7,831,23,1,2,23};
        System.out.println(minNumber(data));
    }


    /**
     * 实现最小数
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {

        sort(nums, 0, nums.length-1);

        //进行输出字符串

        StringBuilder sb=new StringBuilder();

        for (int num : nums) {

            sb.append(num);

        }

        return sb.toString();

    }


    /**
     * 使用快排 进行排序
     * @param data
     * @param lo
     * @param hi
     */
    public static void sort(int[] data,int lo,int hi){

        if (lo>=hi) return;//递归结束条件

        //进行排序

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