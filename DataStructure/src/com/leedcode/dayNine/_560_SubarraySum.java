package com.leedcode.dayNine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

/**
 * @author lqw
 * @date 2022/4/7-9:23 下午
 */
public class _560_SubarraySum {


    public static void main(String[] args) {


        int[] arr=new int[]{1,1,1};

        System.out.println(subarraySum(arr, 2));

    }


    /**
     * 前缀和+hash表
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k){

        //1.先求出数组的前缀和

        int[] prefixSum=new int[nums.length+1];
        prefixSum[0]=0;
        for (int i = 1; i <=nums.length; i++) {//前缀和取到等于
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        //创建一个Hash表存储符合条件的数组
        int res=0;
        Map<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            int diff=prefixSum[i]-k;//目标值
            if (hashMap.containsKey(diff)){//符合条件的数
                res+=hashMap.get(diff);
            }
            //先把前缀之和存储到map中去,因为可能存在多个相等 故需要进行累加操作
            hashMap.put(prefixSum[i], hashMap.getOrDefault(prefixSum[i], 0) + 1);
        }


        return res;
    }

    /**
     * 所求的是 连续字数组--而不是任意子数组
     * 前缀和+线性查找
     * 为什么可以使用前缀和:因为要求的是连续的字数组使用前缀和可以保存连续数组的和数，数组中存在负数 可能会存在多个符合要求的子数组
     * 时间复杂度:O(n^2)
     * 空间复杂度:O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {


        //创建前缀和

        int[] prefixSum=new int[nums.length+1];

        prefixSum[0]=0;

        for (int i = 1; i <=nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        //计算得出前缀和--计算连续数组之和为 k的个数

        int res=0;

        for (int i = 0; i < prefixSum.length; i++) {

            int diff=prefixSum[i]-k;

            for (int j = 0; j <i ; j++) {

                if (prefixSum[j]==diff){

                    res++;
                }

            }

        }

        return res;

    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k){

        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j >=0 ; j--) {
                sum+=nums[j];
                if (sum==k) res++;


            }

        }

        return res;


    }


}