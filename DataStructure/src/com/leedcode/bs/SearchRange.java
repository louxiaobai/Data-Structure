package com.leedcode.bs;

import java.util.Arrays;

/**34. 在排序数组中查找元素的第一个和最后一个位置
 * @author lqw
 * @date 2021/10/11-9:35 上午
 */
public class SearchRange {


    public static void main(String[] args) {

        int[] nums={5,7,7,8,8,10};

        System.out.println(Arrays.toString(searchRange(nums, 8)));

    }

    public static  int[] searchRange(int[] nums,int target){


        if (nums==null||nums.length==0) return new int[]{-1,-1};

         int left=0;
         int right=nums.length-1;
         int[] arr=new int[]{-1,-1};

         int left1=0;
         int right1=nums.length-1;

        while (left1<=right1){ //先找到最左边的target

            int mid=left1+(right1-left1)/2;

            if (nums[mid]==target){

                if (mid==nums.length-1||nums[mid+1]!=target) {

                    arr[1]=mid;
                    break;
                } else{
                    left1=mid+1;
                }
            }else if (nums[mid]>target){

                right1=mid-1;

            }else {
                left1=mid+1;
            }
        }
         while (left<=right){ //先找到最左边的target

             int mid=left+(right-left)/2;

             if (nums[mid]==target){

                  if (mid==0||nums[mid-1]!=target) {

                      arr[0]=mid;
                      break;
                  } else{
                      right=mid-1;
                  }

             }else if (nums[mid]>target){

                        right=mid-1;

             }else {
                 left=mid+1;
             }
         }
        return arr;
    }

}