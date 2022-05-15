package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/14-11:58 上午
 */
public class _201_RangeBitwiseAnd {

    /**
     * 思路:不断的移除right的最后一位1
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right){



        while (left<right){

            right=right&(-right);

        }

        return right;




    }

    /**
     * 思路:找到最大值最小值的位数公共部分就是 全部数字 &的值,left和right同时往左边进行移动 知道 left=right
     * 时间复杂度:O(32)
     * 空间复杂度:O(1)
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd2(int left, int right){

        int count=0;
        while (left<right){
            right=right>>1;
            left=left>>1;
            count++;

        }
        return left<<count;
    }

    /**
     * 时间超时
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd1(int left, int right) {
        int sum=0;
        for (int i = left; i <=right; i++) {

            sum=sum^i;

        }

        return sum;
    }
}