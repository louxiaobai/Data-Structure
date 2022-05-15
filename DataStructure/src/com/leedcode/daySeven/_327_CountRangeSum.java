package com.leedcode.daySeven;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/25-7:22 下午
 */
public class _327_CountRangeSum {


    public static void main(String[] args) {

        _327_CountRangeSum countRangeSum = new _327_CountRangeSum();
        System.out.println( countRangeSum.countRangeSum(new int[]{-2,5,-1},-2,2));

    }


    /**
     * 前缀和+归并排序
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {

        //计算前缀和

        long[] prefixSum=new long[nums.length+1];
        //对前缀和进行赋值
        prefixSum[0]=0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        return sort(prefixSum, 0, prefixSum.length-1, lower, upper);

    }

    public int sort(long[] prefixSum,int lo,int hi,int lower,int upper){

        if (lo>=hi) return 0;
        int mid=lo+((hi-lo)>>1);
        int leftCount=sort(prefixSum, lo, mid, lower, upper);
        int rifhtCount=sort(prefixSum, mid+1, hi, lower, upper);
        //进行计算符合条件的数
        int count=0;
        int leftIndex=lo;
        int rightIndex=mid+1;
        int r=mid+1;
        while (leftIndex<=mid){
            while (rightIndex<=hi&&prefixSum[rightIndex]-prefixSum[leftIndex]<lower) rightIndex++;
            while (r<=hi&&prefixSum[r]-prefixSum[leftIndex]<=upper) r++;
            count+=(r-rightIndex);
            leftIndex++;
        }
        //进行合并操作
        merge(prefixSum, lo, mid, hi);
        return leftCount+rifhtCount+count;
    }

    public void merge(long[] prefixSum,int left,int mid,int right){

        int index=0;//用于拷贝数组的下标

        long[] copyArr=new long[right-left+1];
        int p1=left;
        int p2=mid+1;

        while (p1<=mid&&p2<=right){
            copyArr[index++]=prefixSum[p1]<=prefixSum[p2]?prefixSum[p1++]:prefixSum[p2++];
        }
        while (p1<=mid){
            copyArr[index++]=prefixSum[p1++];
        }
        while (p2<=right){
            copyArr[index++]=prefixSum[p2++];
        }

        //将排序好的数组放入原数组
        for (int i = 0; i < copyArr.length; i++) {
            prefixSum[i+left]=copyArr[i];
        }

    }






    /**
     * 前缀和的计算方式
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum1(int[] nums, int lower, int upper) {
        //计算数组的前缀和
        long[] prefixSum=new long[nums.length+1];
        prefixSum[0]=0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1]=prefixSum[i]+nums[i];//前缀和
        }
        int count=0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i; j < prefixSum.length; j++) {
                long sum=prefixSum[j]-prefixSum[i];
                if (sum<=upper&&sum>=lower) count++;
            }
        }
        return count;
    }



}