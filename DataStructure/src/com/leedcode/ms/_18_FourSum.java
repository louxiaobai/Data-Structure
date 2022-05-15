package com.leedcode.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/1/22-11:59 上午
 */
public class _18_FourSum {

    public static void main(String[] args) {
        int[] arr=new int[]{2,2,2,2};

        System.out.println(fourSum(arr,0));
    }

    /**
     * 双指针法
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        //1.对数组进行排序

        Arrays.sort(nums);

        List<List<Integer>> list=new ArrayList<>();

        for (int i = 0; i < nums.length-3; i++) {

            if (i>0&&nums[i]==nums[i-1]) continue;

            for (int j = i+1; j < nums.length-2; j++) {

                if (j>i+1&&nums[j]==nums[j-1]) continue;

                int sum1=nums[i]+nums[j];

                int left=j+1;
                int right=nums.length-1;

                while (left<right){

                    int sum2=sum1+nums[left]+nums[right];

                    if (sum2==target){

                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while (left<right&&nums[left]==nums[++left]);

                        while (left<right&&nums[right]==nums[--right]);

                    }else if (sum2<target){
                        left++;
                    }else {

                        right--;
                    }

                }

            }



     }

        return list;





    }
}