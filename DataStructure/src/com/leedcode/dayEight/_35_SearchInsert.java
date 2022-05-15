package com.leedcode.dayEight;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/31-11:36 上午
 */
public class _35_SearchInsert {

    public static void main(String[] args) {

        int[] arr=new int[]{1,3,5,6};

        System.out.println(searchInsert(arr,2));


    }

    /**
     * 思路二:二分查找法-不断的进行抛弃不符合的元素
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target){

        if (nums==null||nums.length==0) return -1;
        if (target>nums[nums.length-1]) return nums.length;
        int left=0;
        int right=nums.length-1;
        while (left<right){

            int mid=left+(right-left)/2;
            if (target>nums[mid]){

                left=mid+1;

            }else {
                right=mid;
            }
        }

        return left;


    }

    /**
     * 思路1:常规发-二分查找 找到第第一个大于等于目标元素的下标
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {

         if (nums==null||nums.length==0) return 0;//进行特判断

        if (target>nums[nums.length-1]) return nums.length;//特殊情况

         int left=0;

         int right=nums.length-1;

         while (left<=right){

             int mid=left+(right-left)/2;

             //进行判断

             if (nums[mid]>=target){

                 if (mid==0||nums[mid-1]<target) return mid;
                 else right=mid-1;

             }else{

                 left=mid+1;

             }

         }

         return -1;

    }

}