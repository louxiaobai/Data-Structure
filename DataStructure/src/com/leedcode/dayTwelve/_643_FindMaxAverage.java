package com.leedcode.dayTwelve;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/23-11:02 上午
 */
public class _643_FindMaxAverage {


    public static void main(String[] args) {


        int[] arr=new int[]{-1};


        double maxAverage = findMaxAverage(arr, 1);

        System.out.println(maxAverage);

    }


    /**
     * 滑动窗口计算-
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {

        int left=0;
        int right=0;
        double max=Integer.MIN_VALUE;
        double widowSum=0;

        while (right<nums.length){

            widowSum+=nums[right];

            //如果达到滑动窗口的最大长度 则进行 减去最后一个值 依然保持 窗口的长度为k
            if (right-left+1==k){
                //计算得出 窗口的最大值
                max=Math.max(max, widowSum);
                widowSum-=nums[left];
                left++;
            }
            right++;

        }
        return max/k;



    }
    /**
     * 暴力解法优化 前缀和 --消除掉一部分重复计算--空间换换时间
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage2(int[] nums, int k) {

        //1.计算数组的前前缀和

        int[] preSum=new int[nums.length+1];

        preSum[0]=0;

        for (int i = 1; i <=nums.length ; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        //前缀和计算完毕计算最大值

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-k+1; i++) {
            max=Math.max(max, preSum[i+k]-nums[i]);
        }


        return max/k;



    }

    /**
     * 使用暴力解法--循环遍历 --注意结束条件 不满足 窗口大小 则不进行 计算-超时 要滑动元素的长度为 num.length-k+1
     * 时间复杂度:O(nk)
     * 空间复杂度:O(1)
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage1(int[] nums, int k) {

        double max=Integer.MIN_VALUE;
        for (int i = 0; i <nums.length-k+1 ; i++) {
            double sum=nums[i];
            for (int j = i+1; j <(k+i); j++) {
                sum+=nums[j];
            }
            max=Math.max(sum, max);
        }
        return max/k;
    }
}