package com.leedcode.day;


import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/1/19-9:12 下午
 */
public class ContainsNearbyDuplicate {


    public static void main(String[] args) {

    }


    /**
     * 暴力解法--迭代发
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i <nums.length ; i++) {

            for (int j = i+1; (j<i+1+k&j <nums.length); j++) {

                  if ((nums[i]==nums[j])){
                        return true;
                  }
            }

        }
        return false;


    }

    /**
     * 滑动窗口 以空间换时间
     * @param nums
     * @param k
     * @return
     */

    public boolean containsNearbyDuplicate2(int[] nums, int k){

        int n=nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <n ; i++) {

            if (i>k) set.remove(nums[i-k-1]);

            if (set.contains(nums[i])) return true;

            set.add(nums[i]);


        }

        return false;


    }

}