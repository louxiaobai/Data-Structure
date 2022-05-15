package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/11-11:19 上午
 */
public class _231_IsPowerOfTwo {


    /**
     *使用位运算进行求解
     * 如果一个数是2的整数幂 那么 在这个二进制数中 最多只能有一个一
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n){


        if (n==0) return false;

        long x=n;//防止 数字溢出

        return (x&(x-1))==0;//去掉数字的最后一个1然后进行判断数是否为0⃣️

    }


    /**
     * 使用单独的除发进行运算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n){

        if (n==0) return false;

        while (n%2==0) n=n/2;//看能否被2进行整除

        return n==1;


    }

    /**
     * 递归求解
     * 时间复杂度:O(log2 N)
     * 空间复杂度:O(log2 N)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {

        if (n==1) return true;

        if (n==0) return false;

        if (n%2!=0) return false;


        return isPowerOfTwo1(n/2);



    }



}