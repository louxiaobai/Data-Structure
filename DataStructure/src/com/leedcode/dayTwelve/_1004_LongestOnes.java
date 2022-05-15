package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/25-12:22 下午
 */
public class _1004_LongestOnes {


    /**
     * 滑动窗口
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {

        int left=0;
        int right=0;
        int res=0;
        while (right<nums.length){

            int num=nums[right];
            if (num==0){
                k--;
                if (k==-1){
                    //进行统计最大值
                    res=Math.max(res, right-left);
                }
            }


            while (k==-1){
                if (nums[left]==0) k++;
                left++;
            }
            right++;
        }
        return Math.max(res, right-left);

    }
}