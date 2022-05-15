package com.leedcode.ms;

import java.util.*;

/**
 * @author lqw
 * @date 2022/1/22-11:03 上午
 */
public class _15_ThreeSum {


    /**
     * 暴力求解法
     * 时间复杂度O(n^3 )
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length<3) return new ArrayList<List<Integer>>();

        //创建一个set用来判断是否有重复的的元素

        Set<List<Integer>> hashSet=new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int k = i+1; k < nums.length; k++) {
                for (int j = k+1; j < nums.length; j++) {

                    if (nums[i]+nums[k]+nums[j]==0){

                        List<Integer> temp= Arrays.asList(nums[i],nums[k],nums[j]);

                        Collections.sort(temp);

                        hashSet.add(temp);

                    }

                }

            }
        }


        return new ArrayList<>(hashSet);



    }


    /**
     * 双指针求解
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums){

        //先对数组进行排序

        Arrays.sort(nums);

        //创建一个了列表

        List<List<Integer>> list=new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i>0&&nums[i]==nums[i-1]) continue;

            int target=-nums[i];

            int left=i+1;
            int right=nums.length-1;



            while (left<right){

                int sum=nums[left]+nums[right];

                if (sum==target){

                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while (left<right&&nums[left]==nums[++left]) ;
                    while (left<right&&nums[right]==nums[--right]);

                }else if (sum>target){

                    right--;
                }else {

                   left++;
                }


            }


        }



        return list;

    }

    public static void main(String[] args) {


        int[] arr=new int[]{-1,0,1,2,-1,-4};

        System.out.println(threeSum2(arr));

    }

}