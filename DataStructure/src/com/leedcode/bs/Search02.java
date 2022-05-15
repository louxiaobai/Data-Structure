package com.leedcode.bs;

import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.awt.*;
import java.util.Arrays;

/**leedcode 33. 搜索旋转排序数组--中等
 * @author lqw
 * @date 2021/10/12-11:25 上午
 */
public class Search02 {
    public static void main(String[] args){

        //int[] nums={2,3,4,5,6,7,1};
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));

    }
    /**
     * 旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums,int target){

        if (nums==null||nums.length<1) return -1;

        //数组为 可以分为两半,两半数组都是有序数组--同样可以使用二分排序算法
        int left=0;
        int right=nums.length-1;

        while (left<=right){

            int mid=left+(right-left)/2;

            if (nums[mid]==target) return  mid;

            if (nums[left]<=nums[mid]){//说明左边有序

                if (target>=nums[left]&&target<nums[mid]){

                    right=mid-1;

                }else{

                    left=mid+1;

                }

            }else{

                if (target>nums[mid]&&target<=nums[right]){

                    left=mid+1;
                }else {

                    right=mid-1;
                }

            }

        }

        return -1;
    }

}