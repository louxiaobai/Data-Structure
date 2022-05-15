package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/8-11:04 上午
 */
public class _204_CountPrimes {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));

    }


    /**
     * 埃氏筛法：如果x为质数 那么 2x,3x,4x,5x...都不是质数
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        //创建一个数组 用来存储 不是质数的 数

        if (n<3) return 0;//如果n<3则肯定没有小于n的质数存在
        boolean[] notPrime=new boolean[n];
        int count=0;//记录质数的个数
        for (int i = 2; i <n ; i++) {
            if (notPrime[i]) continue;
            count++;
            //如果i是质数那么 2i，3i 4i ....都不是质数
            for (int j = i+i; j < n; j+=i) {
                notPrime[j]=true;
            }

        }

        return count;


    }

    /**
     * 质数:除了1和它本身以外不再有其他因数的自然数。--超时间
     * 时间复杂度:O(n*n  )
     * 暴力解法
     * @param n
     * @return
     */
    public static int countPrimes1(int n) {

        int count=0;//质数计数器

        for (int i = n-1; i >0 ; i--) {

            int index=i;
            boolean flag=true;
            while (index>1){

                if (index!=i&&i%index==0){
                    flag=false;
                    break;
                }
                index--;
            }
            if (i!=1&&flag) {

                count++;
                System.out.println(i);

            }

        }


        return count;

    }


}