package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/4-5:06 下午
 */
public class Byte {


    public static void main(String[] args) {

        int[] arr=new int[]{4,7,2,10,5};

        System.out.println(getCount(arr, 4));



    }

    /**
     * 暴力解法
     * @param arr
     * @param k
     * @return
     */
    public static int getCount(int[] arr,int k){

        int m=1;//从1进行开始
        int num=0;
        for (int i = 0; i < arr.length; i++) {


            num+= Math.max((arr[i] / m), 0);
            if (num>k){
                m++;
                num=0;
                i=-1;

            }

        }

        return m;

    }


}