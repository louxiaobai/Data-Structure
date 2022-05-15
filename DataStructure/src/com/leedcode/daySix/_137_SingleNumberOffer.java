package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/13-11:28 上午
 */
public class _137_SingleNumberOffer {


    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j <4 ; j++) {

                System.out.println(1<<i);

            }
        }


    }


    /**
     * 方法二:统计每位上1的总数
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @return
     */
    public static int singleNumbe(int[] nums){


        int res=0;

        for (int i = 0; i <=31; i++) {

            int count=0;//统计1出现次数

            for (int num : nums) {
                 count+=(num>>i)&i;
            }
            if (count%3!=0){//如果不是三的倍数 说明该位只出现了一次
                res=res|1<<i;
            }
        }

        return res;

    }


    /**
     * 方法1:使用异或的方式求解(不太好想)--
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {

        int once=0;
        int twice=0;

        for (int num : nums) {

            once=once^num&~twice;

            twice=twice^num&~once;

        }
        return once;


    }


}