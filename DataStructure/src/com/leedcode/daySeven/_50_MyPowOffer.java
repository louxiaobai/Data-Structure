package com.leedcode.daySeven;

/**
 * @author lqw
 * @date 2022/3/27-11:24 上午
 */
public class _50_MyPowOffer {

    public static void main(String[] args) {


        System.out.println(-2147483548>>>1);

    }


    /**
     * 位运算求解:
     * 时间复杂度:
     * @param x
     * @param n
     * @return
     */

    public static double myPow(double x, int n) {
        if (n==0) return 1.0;
        int sign=n>0?1:-1;
        double res=1;
        long b=n;

        b=Math.abs(b);
        while (b!=0){
            //取出n的个位数
            if ((b&1)==1) res*=x;
            x=x*x;
            b=b>>1;//向右移动一位
        }
        return sign==1?res:1/res;

    }

    /**
     * 使用快速幂进行求解:类似归并排序----一分为2的情况   想到归并排序
     * 时间复杂度:O(logn)
     * 空间复杂度:O(logn)
     * @param x
     * @param n
     * @return
     */

    public double myPow2(double x, int n) {

        if (n==0) return 1.0;

        int sign=n>0?1:-1;

        return sign==1?quickPow(x, n):1/quickPow(x, n);


    }

    public double quickPow(double x,int n){

        if (n==1) return x;

        if (n==0) return 1.0;

        int mid=n/2;

        double result=quickPow(x, mid);

        return n%2==0?result*result:x*result*result;
    }

    /**
     * 思路:进行累乘---会超时
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {


        if (n==0) return 1.0;

        int sign=n>=0?1:-1;
        double res=x;
        for (int i = 1; i <Math.abs(n); i++) {

              res=res*x;

        }

        return sign==1?res:1/res;



    }
}