package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/14-3:25 下午
 */
public class _476_FindComplement {


    /**
     * 思路:1.mask找到num的前导0然后 ～mask和num 求一次异或 得到的就是 num的补数
     * 时间复杂度:O(1)
     * 空间复杂度:O(1)
     * @param num
     * @return
     */
    public static int findComplement(int num) {

        int mask=~0;//定义一个 全1


        while ((mask&num)>0) mask<<=1;


        return ~mask^num;





    }



}