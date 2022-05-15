package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/11-10:46 上午
 */
public class _1480_RunningSum {


    /**
     * 暴力循环优化(一次循环)
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            nums[i]=nums[i-1]+nums[i];

        }


        return nums;

    }
    /**
     * 暴力解法（两次循环从后往前进行计算）
     * 空间复杂度O(1)
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int[] runningSum1(int[] nums) {

        //从后往前进行遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp=0;
            for (int j = 0; j <=i ; j++) {
                 temp+=nums[j];
            }
            nums[i]=temp;
        }

        return nums;


    }




}