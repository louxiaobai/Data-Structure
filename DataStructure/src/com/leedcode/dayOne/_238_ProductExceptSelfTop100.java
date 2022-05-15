package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/2/11-11:17 上午
 */
public class _238_ProductExceptSelfTop100 {

    /**
     * 暴力解法优化
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */

    public int[] productExceptSelf(int[] nums) {


        //定义一个输出数组用来存储左右乘积

        int[] outPut=new int[nums.length];
        //存储左积
        outPut[0]=1;
        for (int i = 1; i < nums.length; i++) {
            outPut[i]=nums[i-1]*outPut[i-1];
        }

        //进行计算右边乘积
        int temp=1;
        for (int i = nums.length - 1; i >= 0; i--) {
            outPut[i]=outPut[i]*temp;
            temp=temp*nums[i];
        }
        return outPut;

    }
    /**
     * 暴力解法
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {


        //1.先计算出数组中每个位置左边的积

        int[] leftArr=new int[nums.length];

        leftArr[0]=1;

        for (int i = 1; i <nums.length ; i++) {
            leftArr[i]=nums[i-1]*leftArr[i-1];
        }

        //2.计算出数组中每个位置右边的乘积
        int[] rightArr=new int[nums.length];

        rightArr[nums.length-1]=1;

        for (int i = nums.length - 2; i >= 0; i--) {
            rightArr[i]=rightArr[i+1]*nums[i+1];
        }


        for (int i = 0; i < nums.length; i++) {

            nums[i]=leftArr[i]*rightArr[i];

        }


        return nums;


    }



}