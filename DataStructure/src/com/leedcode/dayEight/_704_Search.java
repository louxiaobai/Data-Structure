package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/3/31-10:27 上午
 */
public class _704_Search {

    public int search(int[] nums, int target) {

         if (nums==null||nums.length==0) return -1;

         int left=0;

         int right=nums.length-1;

         while (left<=right){//结束查找

             int mid=left+(right-left)/2;

             if (nums[mid]==target){
                 return mid;
             }else if (nums[mid]>target){//说明此时要查找的元素在mid的左边

                 right=mid-1;
             }else{

                 left=mid+1;

             }



         }

         return -1;




    }
}