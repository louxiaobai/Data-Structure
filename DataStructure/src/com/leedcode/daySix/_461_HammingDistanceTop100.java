package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/10-11:38 上午
 */
public class _461_HammingDistanceTop100 {

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 思路:有多少个不同的数 汉明距离 距离就是多少
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {


        //1.先求x和y的异或 然后求解1的个数
        int n=x^y;

        int count=0;//记录1的个数

        while (n!=0){

            n=n&(n-1);//去掉最后一位1
            count++;
        }

        return count;//1.个数就是汉明距离

    }
}


