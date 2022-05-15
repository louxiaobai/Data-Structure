package com.leedcode.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/13-4:32 下午
 */
public class _135_Candy {


    /**
     * 优化的暴力解法
     *从左遍历+从右遍历 取糖果的最大值
     * @param ratings
     * @return
     */
    public int candy(int[] ratings){

        int n=ratings.length;

        int[] leftcandies=new int[n];

        Arrays.fill(leftcandies, 1);

        int[] rightCandies=new int[n];

        Arrays.fill(rightCandies, 1);

        //从左往右分发糖果

        for (int i = 0; i < ratings.length; i++) {

            if (i!=0&&ratings[i]>ratings[i-1]&&leftcandies[i]<=leftcandies[i-1]){


                leftcandies[i]=leftcandies[i-1]+1;

            }

        }


        //从右往左分发糖果

        int sum=0;//记录总的糖果数

        for (int i = ratings.length - 1; i >= 0; i--) {

            if (i!=n-1&&ratings[i]>ratings[i+1]&&rightCandies[i]<=rightCandies[i+1]){

                rightCandies[i]=rightCandies[i+1]+1;
            }

            sum+=Math.max(rightCandies[i],leftcandies[i]);

        }

        return sum;


    }


    /**
     * 暴力解法
     * 时间复杂度O(n^2)
     * @param ratings
     * @return
     */
    public int candy1(int[] ratings) {

        //1.创建一个存储糖果的数组

        int n=ratings.length;

        //创建一个存储糖果的数组

        int[] candyies=new int[n];

        //对数组进行赋值

        Arrays.fill(candyies, 1);//每个下标对应的值都是1

        boolean falg=true;

        while (falg) {//因为一轮分发 不能 完全 确定每个同学的糖果 所以需要多次分发糖果 如 9 8 7 6 5 4 3 2 1

            falg=false;

            for (int i = 0; i < ratings.length; i++) {

                //如果当前值比右边的大 则需要对 糖果数加一

                if (i != n - 1 && ratings[i] > ratings[i + 1] && candyies[i] <= candyies[i + 1]) {

                    candyies[i] = candyies[i + 1] + 1;

                    falg=true;
                }

                //如果当前值比左边的大 则需要对 糖果数加一

                if (i != 0 && ratings[i] > ratings[i - 1] && candyies[i] <= candyies[i - 1]) {
                    candyies[i] = candyies[i - 1] + 1;
                    falg=true;
                }

            }

        }
        //计算总数

        int sum=0;

        for (int candyy : candyies) {

            sum+=candyy;
        }


        return sum;

    }

}