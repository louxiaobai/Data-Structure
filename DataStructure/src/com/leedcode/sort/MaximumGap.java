package com.leedcode.sort;

import java.util.Arrays;

/**164. 最大间距 困难
 * @author lqw
 * @date 2021/10/6-5:12 下午
 */
public class MaximumGap {

    public static void main(String[] args) {

       int[] arr=new int[]{100,3,2,1};


       System.out.println(maximumGap(arr));
        System.out.println(Arrays.toString(arr));
    }


    public static int maximumGap(int[] nums) {

        if(nums.length<=1) return 0;
        sort(nums,0,nums.length-1);//数组有序
        //进行遍历数组找到最大间距
        int gap=0;
        for(int i=1;i<nums.length;i++){

            if(nums[i]-nums[i-1]>gap){

                gap=nums[i]-nums[i-1];
            }
        }
        return gap;
    }


    //进行快排

    public static void sort(int[] data,int lo,int hi){

        if(lo>=hi) return;

        int left=lo;
        int right=hi;
        int index=left;
        int pivot=data[right];
        while(index<=right){

            if(data[index]<pivot){
                int temp=data[index];
                data[index]=data[left];
                data[left]=temp;
                left++;
                index++;

            }else if(data[index]>pivot){
                int temp=data[index];
                data[index]=data[right];
                data[right]=temp;
                right--;

            }else{

                index++;
            }

        }
        sort(data,lo,left-1);
        sort(data,right+1,hi);
    }
}