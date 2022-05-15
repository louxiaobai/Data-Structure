package com.leedcode.day;

/**
 * @author lqw
 * @date 2022/1/15-9:05 下午
 */
public class TotalMoney {

    public static void main(String[] args) {

        System.out.println(totalMoney(20));

    }

    /**
     * 第一周期 存的钱数为 28 第二个周期 则为28*2+7  第三个周期 28*3+7+7*2
     *  规律 为  a*28+(a-1)*7
     * 不成周期的数为 b+(a)
     * 运用到了等比数列的求和公式
     * @param n
     * @return
     */


    //等差数列 求和公式 --- na+((n(n-1))/2)d   其中a为 首项  n 为 项数  d为 差值

    //等比数列 (a1-an*q)/1-q

    public static int totalMoney(int n) {

        int m = n / 7;
        int k = n % 7;
        int preWeeksAll = m * 28 + 7 * ((m - 1) * m / 2); // 前面几个完整的星期，总共存入多少
        int lastWeek = k * (k + 1) / 2 + m * k; // 最后一个星期那几天存入多少

        return preWeeksAll+lastWeek;
    }
}