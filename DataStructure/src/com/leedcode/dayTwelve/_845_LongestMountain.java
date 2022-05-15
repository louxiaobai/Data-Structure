package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/28-12:29 下午
 */
public class _845_LongestMountain {

    /**
     * 滑动窗口-山脉特点 最少需要三个元素-最后两个直接不用判断
     * @param arr
     * @return
     */
    public int longestMountain(int[] arr) {

        int n=arr.length;
        int left=0;
        //记录最大山脉的长度
        int len=0;

        while (left+2<n){
            int right=left+1;
            if (arr[left]<arr[right]){//说明有可能存在山脉数组
                //找到最高点
                while (right<n-1&&arr[right]<arr[right+1]){
                    right++;
                }
                if (right<n-1&&arr[right]>arr[right+1]){//说明存在山脉数组
                    while (right<n-1&&arr[right]>arr[right+1]){
                        right++;
                    }
                    //进行计算山脉数组的最大值
                    len=Math.max(len, right-left+1);
                }else {//则不是山脉数组
                    right++;
                }
            }
            left=right;
        }
        return len;
    }
}