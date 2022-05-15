package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/11-11:46 上午
 */
public class _371_FetSum {

    /**
     * 思路:二进制加法-->异或运算相当于无进位的二进制加法-
     * 计算就是需要-a和b先进性异或计算得到x，a和b进行于运算得到y然后y左移一位 得到y x和y在次进行异或就是两数之和
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {

        //因为进位可能不只是进位一次所以需要进行while循环 知道进位 为0 为止
        while (b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;

        }


        return a;





    }
}