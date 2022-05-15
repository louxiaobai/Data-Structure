package com.leedcode.day;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/1/13-6:50 下午
 */
public class DominantIndex {


    public static void main(String[] args) {

        int[] nums = new int[]{5, 3, 1, 2, 3, 4, 51, 1};


        System.out.println(dominantIndex(nums));


    }


    /**
     * 找到次最大值和最大值进行比较即可
     * @param nums
     */
    public static int dominantIndex(int[] nums) {

        if (nums.length == 1) return 0;

        int max=0;
        int secondMax=0;
        int index=0;

        for (int i = 0; i <nums.length ; i++) {

            if (nums[i]>max){

                secondMax=max;
                max=nums[i];
                index=i;

            }else{

                if (nums[i]>secondMax){

                    secondMax=nums[i];
                }

            }

        }


        return secondMax*2>max? -1:index;

    }
}