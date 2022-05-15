package com.leedcode.ms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lqw
 * @date 2022/1/22-8:19 上午
 */
public class _1_Solution {



    /**
     * 两数之和 暴力解法
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] arr=new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j <nums.length ; j++) {

                if (nums[i]+nums[j]==target){

                    arr[0]=i;
                    arr[1]=j;

                    break;
                }
            }
        }

        return arr;
    }

    /**
     * hash求解
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 以空间换时间
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum2(int[] nums, int target){

        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

           int x=nums[i];

           if (map.containsKey(target-x)){

               return new int[]{i,map.get(target-x)};


           }

           map.put(x, i);

        }



        return new int[0];

    }


}