package com.leedcode.dayThirteen;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lqw
 * @date 2022/4/29-12:17 下午
 */
public class _1_TwoSum {

    public static void main(String[] args) {

        int[] arr=new int[]{3,2,4};

        System.out.println(Arrays.toString(twoSum(arr, 6)));

    }


    /**
     * 最优解-空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num=nums[i];

            if (hashMap.containsKey(num)){

                return new int[]{hashMap.get(num),i};

            }

            hashMap.put(target-num, i);

        }

        return null;

    }


}