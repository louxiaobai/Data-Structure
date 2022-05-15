package com.leedcode.dayTwo;

/**
 * @author lqw
 * @date 2022/2/13-8:37 下午
 */
public class _605_CanPlaceFlowers {


    public static void main(String[] args) {


        int[] arr={1,0,0,0,1};


        canPlaceFlowers(arr,1);

    }
    /**
     * 暴力解法
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        //对种花的情况分一下进行讨论
        //1.当前位置种花了 则需要到 index+2的地方进行再次判断
        //2.当前位置没有种花 并且 下一个位置也没有种花 则当前位置可以种花
        //3.当前位置没有种花 但是 下个位置种花了 则需要 index+3的地方进行判断

        int index=0;

        while (index<flowerbed.length&&n>0){


            if (flowerbed[index]==1){//不能种花 需要 +2

                index+=2;

            }else if (index==flowerbed.length-1||flowerbed[index+1]==0){

                n--;
                index+=2;

            }else {

                index+=3;
            }


        }

        return n==0;


    }
}