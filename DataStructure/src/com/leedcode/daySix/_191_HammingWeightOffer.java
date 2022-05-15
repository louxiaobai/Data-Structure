package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/10-10:35 上午
 */
public class _191_HammingWeightOffer {


    /**
     * 思路:使用判断某个位是否位1的技巧:(n&1<<1)--对每一位进行测试
     * 时间复杂度O(1)
     * 空间复杂度:O(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {

        int count=0;
        for (int i = 0; i < 32; i++) {

            if ((n&1<<i)!=0) count++;

        }

        return count;

    }

    /**
     * 思路:右移n 然后和1进行与操作
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {

        int count=0;
        for (int i = 0; i < 32; i++) {

            if ((n&1)!=0) count++;

            n=n>>1;//n无符号右移动一位

        }

        return count;
    }


    /**
     * 思路:去掉最后一个1(n&(n-1))--最优解
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {

        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }






    }