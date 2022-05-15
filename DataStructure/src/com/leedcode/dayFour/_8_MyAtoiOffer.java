package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/4-9:30 上午
 */
public class _8_MyAtoiOffer {

    public static void main(String[] args) {
        String s="2147483648";

        _8_MyAtoiOffer myAtoi = new _8_MyAtoiOffer();



        System.out.println( myAtoi.myAtoi(s));

    }


    /**
     * 思路:直接模拟法--重点是 判断 数字越界情况,和如何计算这个数
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param s
     * @return
     */
    public int myAtoi(String s) {


        char[] chars = s.toCharArray();


        //1.去掉前后空格

        int i=0;
        while (i<s.length()&&chars[i]==' '){
            i++;
        }
        if (i==s.length()) return 0;
        int sign=1;
        //2.判定符号位是正还是负数
        if (chars[i]=='-'||chars[i]=='+'){
            sign=chars[i]=='-'? -1:1;
            i++;
        }
        int base=0;
        while (i<chars.length&&chars[i]>='0'&&chars[i]<='9'){

            //最小值-2147483648 最大值2147483647--检查数字是否出现越界 现象
            if (base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10&&chars[i ]-'0'>7)){

                if (sign>0) return Integer.MAX_VALUE;

                else return Integer.MIN_VALUE;

            }

            base = base * 10 + (chars[i] - '0');
            i++;

        }

        return sign*base;

    }
}

