package com.leedcode.ms;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/1/22-9:04 上午
 */
public class _167_TwoSum {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,4,9,56,90};

        System.out.println(Arrays.toString(twoSum(arr, 8)));
    }


    /**
     * 二分查找
     * 时间复杂度O(nlog)
     * 空间复杂度O(1)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {


        for (int i = 0; i < numbers.length; i++) {

            int x=bianrySearch(numbers, target-numbers[i],i);

            if (x!=1001){

                return new int[]{i+1,x+1};

            }
        }
        return new int[0];
    }

    public static int bianrySearch(int[] nums,int target,int i){

        int left=0;

        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;//找到中间点
            if (nums[mid]==target&&mid!=i){
                return mid;
            }
            if (nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }

        return 1001;

    }


    /**
     * 双指针解法--可以有效的降低时间和空间复杂度
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target){

        int left=0;
        int right=numbers.length-1;

        while (left<right){


            if (numbers[left]+numbers[right]==target){

                return new int[]{left+1,right+1};

            }else if (numbers[left]+numbers[right]<target){

                left=left+1;
            }else{
                right=right-1;
            }



        }

        return new int[0];


    }



}