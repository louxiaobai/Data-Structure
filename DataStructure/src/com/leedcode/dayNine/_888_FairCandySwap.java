package com.leedcode.dayNine;


import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/4/5-11:05 上午
 */
public class _888_FairCandySwap {

    /**
     * 思路:假设  A 出 x个糖果 B 出y个糖果 这样交换他俩的数量就是相同的则可以 sumA-x+y=sumB-y+x
     * 即有x=y+(sumA-sumB)/2---y=x-(sumA-sumB)/2
     * 使用hash表存储A中的数据 然后进行比对 即可
     * 时间复杂度:O(n)
     * 空间复杂度:O(m)
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA=0;
        for (int aliceSize : aliceSizes) {
            sumA+=aliceSize;
        }
        int sumB=0;
        for (int bobSize : bobSizes) {
            sumB+=bobSize;
        }

        //将 bobSizes用hash表进行存储

        Set<Integer> set=new HashSet<>();

        for (int bobSize : bobSizes) {
            set.add(bobSize);
        }

        //初始化一个数组进行存储数据
        int[] ans=new int[2];
        for (int aliceSize : aliceSizes) {

            //y=x-(sumA-sumB)/2

            int num=aliceSize-(sumA-sumB)/2;

            if (set.contains(num)){

                ans[0]=aliceSize;
                ans[1]=num;
                break;

            }
        }

        return ans;





    }
}