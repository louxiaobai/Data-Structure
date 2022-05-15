package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/25-11:42 上午
 */
public class _485_FindMaxConsecutiveOnes {


    /**
     * 滑动窗口
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {


        int left=0;

        int right=0;

        int res=0;

        while (right<nums.length) {

            if (nums[right]==0){
                res=Math.max(res, right-left);
                left=right+1;
            }

            right++;


        }


        return res;


    }


    /**
     * 线性扫描
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int res=0;

        int index=0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i]==1){
                index++;
            }else {
                res=Math.max(res, index);
                index=0;
            }
        }
        return Math.max(res,index);
    }
}