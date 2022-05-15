package com.leedcode.daySix;

/**
 * @author lqw
 * @date 2022/3/12-8:33 下午
 */
public class _29_DivideOffer {


    public static void main(String[] args) {

        System.out.println((-2147483648)>>>1);
    }

    /**
     * 思路:使用减发代替除法,从最大值开始减 如果 减去后结果>=0说明能够整除,直到不能除为止
     * 时间复杂度:O(1)
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {

        if (a==Integer.MIN_VALUE&&b==-1) return Integer.MIN_VALUE;
        //进行判断运算符
        int sign=(a>0)^(b>0) ?-1:1;//进行异或运算得出运算符号的正负
        //计算a中有多个b-int类型的取值范围为[-2^31-1,2^31]=[-2147483648.21343483647]
        //使用正数进行计算-如果 值为-2147483648则绝对值也是为负数
        a=Math.abs(a);
        b=Math.abs(b);
        int sum=0;
        for (int i = 31; i >=0 ; i--) {
            //考虑边界情况
            //1.左移会发生越界的情况,所以需要把左移转换成右移
            //2.为了使得a永远为正数这里需要采用无符号右移 -例如-2147483548>>>1 =1073741824
            //3.减去b会了防止 b为最小值 -2147483648,如果b为最小值则if永远为true
            // if (a>=b<<i){//如果a大于b移动i位
            if((a>>>i)-b>0){
                a-=b<<i;//a减去b<<i
                if (sum>=Integer.MIN_VALUE-(1<<i)){
                    return Integer.MIN_VALUE;
                }
                sum+=(1<<i);
            }
        }
        return sign==1? sum:-sum;
    }
}