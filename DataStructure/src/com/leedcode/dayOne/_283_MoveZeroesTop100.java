package com.leedcode.dayOne;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/1/23-3:16 下午
 */
public class _283_MoveZeroesTop100 {

    public static void main(String[] args) {

        int[] arr=new int[]{1,0,0};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));


    }

    /**
     * 双指针法
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

         if (nums.length==0) return;

         int slow=0;
         int fast=1;

         while (fast<nums.length){
             if (nums[slow]==0&&nums[fast]!=0){
                 //进行交换
                 int temp=nums[slow];
                 nums[slow]=nums[fast];
                 nums[fast]=temp;
                 slow++;
             }else if (nums[slow]!=0){
                 slow++;
             }
             fast++;
         }
    }
}