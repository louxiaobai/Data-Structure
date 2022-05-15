package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/8-11:50 上午
 */
public class _233_CountDigitOne {

    /**
     * 找规律:
     * @param n
     * @return
     */
    public int countDigitOne(int n) {

        if(n==0) return 0;
        if (n<10) return 1;

        int sum=0;

        for (int i = 1; i <= n; i=i*10) {

            //规律如下:
            //个位数的1=(n/10)*1+min(max(n%10-1+1,0),1)
            //十位数的1=(n/100)*10+min(max(n%100-10+1,0),10)
            //百位数的1=(n/1000)*100+min(max(n%1000-100+1,0),100)
            long driver=i*10;//有可能数字溢出这里使用long类型
            sum+=(n/driver)*i+Math.min(Math.max(n%driver-i+1, 0L), i);

        }

        return sum;


    }

    /**
     * 暴力解法：每个数字都进行遍历是--
     * 时间复杂度:O(n*n)
     * @param n
     * @return
     */
    public int countDigitOne1(int n) {
        if(n==0) return 0;
        if (n<10) return 1;
        int count=1;//用于记录1的个数
        for (int i = 10; i <=n; i++) {

            String s=String.valueOf(i);

            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j)=='1') count++;

            }

        }


        return count;


    }
}