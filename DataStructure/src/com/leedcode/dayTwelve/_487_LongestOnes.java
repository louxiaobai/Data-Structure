package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/25-12:11 下午
 */
public class _487_LongestOnes {


    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public int longestOnes(int[] nums) {
        int left=0;

        int right=0;

        int res=0;

        int  k=0;

        while (right<nums.length){

            int num=nums[right];
            if (num==0){
                k++;
                if (k==2){
                    //进行计算最大窗口数
                    res=Math.max(res, right-left);
                }
            }
            while (k==2){
                if (nums[left]==0) k--;
                left++;
            }
            right++;
        }
        return Math.max(res, right-left);
    }
}