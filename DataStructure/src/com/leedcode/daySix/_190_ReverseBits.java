package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/14-4:29 下午
 */
public class _190_ReverseBits {

    /**
     * 思路:将数据与1进行 与操作 然后 不断的 与res 进行或操作(或操作之前需要将res进行向右移动一位)
     *时间复杂度:O(1)
     * 空间复杂度:O (1)
     * @param n
     * @return
     */
    public int reverseBits1(int n) {

        int res=0;
        for (int i = 0; i < 32; i++) {
            res=(res<<1)|(n&1);
            n=n>>1;
        }
        return res;
    }
}