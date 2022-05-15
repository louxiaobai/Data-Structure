package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/2-10:55 下午
 */
public class _162_FindPeakElement {

    /**
     * 思路:二分查找
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {


        if (nums.length==1) return 0;

        if (nums.length==2) return nums[0]>nums[1]?0:1;


        int left=0;

        int right=nums.length-1;

        while (left<=right){

            int mid=left+(right-left)/2;

            if (nums[mid]<nums[mid+1]){

                left=mid+1;

            }else {

                right=mid;
            }

        }


        return left;


    }


}