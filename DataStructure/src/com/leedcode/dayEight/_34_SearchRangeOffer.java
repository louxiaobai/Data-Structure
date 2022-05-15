package com.leedcode.dayEight;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/31-10:51 上午
 */
public class _34_SearchRangeOffer {

    public static void main(String[] args) {

        int[] arr=new int[]{2,2};

        System.out.println(Arrays.toString(searchRange(arr, 2)));

    }


    /**
     * 思路:两次二分查走--一次查找最左边--一次查找最右边
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {

            if (nums==null||nums.length==0)  return new int[]{-1,-1};
            int[] arr=new int[]{-1,-1};
            int left=0;
            int right=nums.length-1;
            while (left<=right){//进行循环的条件--先找到最左边的
                int mid=left+(right-left)/2;
                if (nums[mid]==target){
                    if (mid==0||nums[mid-1]!=target){
                        arr[0]=mid;
                        break;
                    }else{
                        right=mid-1;
                    }
                }  else if (nums[mid]>target){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }

            //查找最大的索引

            int left1=0;

            int right1=nums.length-1;

            while (left1<=right1){

                int mid=left1+(right1-left1)/2;

                if (nums[left1]==target){

                    if (mid==nums.length-1||nums[mid+1]>target){

                        arr[1]=mid;
                        break;

                    }else {


                        left1=mid+1;

                    }


                }else if (nums[mid]>target){

                      right1=mid-1;

                }else{

                     left1=mid+1;

                }


            }

            return arr;

    }

}