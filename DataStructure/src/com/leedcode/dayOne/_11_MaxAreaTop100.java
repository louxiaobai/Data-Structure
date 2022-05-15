package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/10-2:57 下午
 */
public class _11_MaxAreaTop100 {


    /**
     * 对撞指针
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int left=0;
        int right=height.length-1;
        int max=0;

        while (left<right){

            max=Math.max(max, (right-left)*Math.min(height[left],height[right]));

            if (height[left]<height[right]){

                left++;
            }else {

                right++;
            }

        }

        return max;
    }

    /**
     *暴力解法--超时
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

        //定义最大值
        int max=0;
        for (int i = 0; i < height.length; i++) {

            for (int j = i; j <height.length ; j++) {

                max=Math.max(max, (j-i)*Math.min(height[i],height[j]));

            }
        }
        return max;
    }




}