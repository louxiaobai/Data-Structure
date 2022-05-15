package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/1-11:59 上午
 */
public class _154_FindMinOffer {



    public int findMin(int[] nums) {

        if (nums==null||nums.length==0) return -1;


        int left=0;
        int right=nums.length-1;

        while (left<right){


            int mid=left+(right-left)/2;


            if (nums[mid]>nums[right]){//最小值 在右边

                left=mid+1;

            }else if (nums[mid]<nums[right]){//最小值在左边

                right=mid;

            }else {//此时 nums[mid]==nums[right]

                right--;

            }




        }


        return nums[left];

    }



}