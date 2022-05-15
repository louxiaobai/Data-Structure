package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/4-10:44 上午
 */
public class _69_MySqrt {

    public static void main(String[] args) {


        System.out.println(mySqrt(2147483647));



    }

    /**
     * 二分解法:注意点:mid*mid 可能会溢出--1.可以进行转型long 2.可以使用除法
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1    )
     * @param x
     * @return
     */
    public static int mySqrt(int x) {


        if (x<=1) return x;

        int left=0;
        int right=x;


        while (left<right){

            int mid=left+(right-left)/2;

            //mid*mid 可能会发生溢出现象


            if (x/mid>mid){

                left=mid+1;

            }else {

                right=mid;
            }


        }



        return (x/left)==left?left:left-1;



    }

    /**
     *暴力解法
     *时间复杂度:O(n)
     *空间复杂度:O(1)
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {

        if (x<=1) return x;

        int index=1;

        for (int i = 1; i <x ; i++) {

//            int sum=i*i;//因为可能会出现溢出 不能使用这个

            int divi=x/i;

            if (divi==i){
                index=i;
                break;
            }else if (divi<i){
                index=i-1;
                break;
            }


        }


        return index;

    }


}