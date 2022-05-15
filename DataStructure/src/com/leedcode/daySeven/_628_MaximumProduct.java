package com.leedcode.daySeven;

import com.highlevel.map.Map;

/**
 * @author lqw
 * @date 2022/3/23-10:15 上午
 */
public class _628_MaximumProduct {

    /**
     * 思路:因为数组中存在负数--不能单纯大查找前三个最大值,需要找到最小的两个值
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {

        if (nums.length==3) return nums[0]*nums[1]*nums[2];


        //只需要遍历一遍数组即可

        int max=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int three=Integer.MIN_VALUE;

        //因为存在负数 所以需要找到最小的两个数

        int min=Integer.MAX_VALUE;
        int minSecond=Integer.MAX_VALUE;

        //遍历一遍数组


        for (int i = 0; i < nums.length; i++) {

            if (nums[i]>max){
                //第二大继承第一大的元素,第三大继承第二大的元素
                three=second;
                second=max;
                max=nums[i];
            }else if (nums[i]>second){
                //第三大继承第二大的元素
                three=second;
                second=nums[i];
            }else if (nums[i]>three){
                three=nums[i];
            }

            //进行找最小值


            if (nums[i]<min){

                minSecond=min;
                min=nums[i];

            }else if (nums[i]<minSecond){
                minSecond=nums[i];
            }

        }


        return Math.max(max*second*three,min*minSecond*max);






    }
}