package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/10-12:00 下午
 */
public class _477_TotalHammingDistance {


    public static void main(String[] args) {

        System.out.println((2>>1)&1);

    }

    /**
     * 思路:计算每一位的汉明距离然后进行相加得到总的汉明距离
     * 时间复杂度:o(n)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */

    public int totalHammingDistance(int[] nums){

        int n=nums.length;

        //创建一个数组用来存储每一位的1的个数

        int[] count=new int[32];//最多有32位


        for (int num : nums) {

            int index=0;

            while (num>0){


                count[index]+=num&1;

                num=num>>1;

                index++;

            }

        }


        int sum=0;//用来记录总的距离

        for (int i : count) {

            sum+=i*(n-i);

        }

        return sum;



    }


    /**
     * 暴力解法:计算每两个汉明距离然后进行累加
     * 超时
     * @param nums
     * @return
     */
    public int totalHammingDistance1(int[] nums) {


        int sum=0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j <nums.length ; j++) {


                sum=sum+hammingDistance(nums[i], nums[j]);

            }

        }

        return sum;

    }


    public int hammingDistance(int x, int y) {


        //1.先求x和y的异或 然后求解1的个数
        int n=x^y;

        int count=0;//记录1的个数

        while (n!=0){

            n=n&(n-1);//去掉最后一位1
            count++;
        }

        return count;//1.个数就是汉明距离

    }






}