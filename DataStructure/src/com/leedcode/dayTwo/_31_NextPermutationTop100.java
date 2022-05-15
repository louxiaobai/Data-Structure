package com.leedcode.dayTwo;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/2/13-12:38 下午
 */
public class _31_NextPermutationTop100 {


    public static void main(String[] args) {

        int[] arr={1,2,3};

        nextPermutation(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i=nums.length-2;

        while (i>=0&&nums[i]>=nums[i+1]) i--;

        if (i>=0){

            int k=nums.length-1;
            //从后往前找找到第一个比nums[i]大的数
            while (k>=0&&nums[i]>=nums[k]) k--;
            //交换i和k的值
            int temp=nums[i];
            nums[i]=nums[k];
            nums[k]=temp;

        }

        //将数组进行反转

        reserveArr(nums, i+1, nums.length-1);

    }

    public static void reserveArr(int[] arr,int start,int end){

        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}