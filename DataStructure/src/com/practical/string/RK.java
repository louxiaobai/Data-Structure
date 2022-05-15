package com.practical.string;

import com.highlevel.map.Map;

/**
 * @author lqw
 * @date 2022/3/2-11:12 上午
 */
public class RK {

    public static void main(String[] args) {

        RK rk = new RK();

        System.out.println(rk.indexOf("123", "1233"));
    }


    /**
     *哈希发进行字符串查询操作
     * @param target
     * @param source
     * @return
     */
    public int indexOf(String target,String source ){

        if (target==null||source==null) return -1;

        int m= source.length();
        int n= target.length();

        if (m<n) return -1;

        //1.创建一个数组用于存储哈希值

        int[] hashArr=new int[m-n+1];


        //2.计算出第一个子串的hash值


        hashArr[0]=getFirstHash(source.substring(0, n));

        //3.将所有可能的字符的hash值进行存储到数组中(根据前一个子串 计算下一个子串的hash值)
        for (int i = 1; i < m+n-1; i++) {

            hashArr[i]=getNextHash(source, hashArr, n, i);

        }

        //4.计算出匹配串的hash值

        int targetHash=getFirstHash(target);


        for (int i = 0; i < m+n-1; i++) {

            if (targetHash==hashArr[i]){

                return i;
            }

        }

        return -1;
    }


    /**
     * 计算字符串的hash值
     * @param target
     * @return
     */
    public int getFirstHash(String target){

        int len=target.length();

        int hashCode=0;

        for (int i = 0; i < len; i++) {

            hashCode+= (int) Math.pow(26, i)*(target.charAt(i)-'a');

        }

        return hashCode;

    }

    /**
     * 计算出原字符串中的下一个子串的hash值
     * @param source
     * @param hashCode
     * @param n
     * @param i
     * @return
     */
    public int getNextHash(String source,int[] hashCode,int n,int i){

        return hashCode[i - 1] * 26 - (source.charAt(i - 1) - 'a') * (int) Math.pow(26, n)
                + (source.charAt(i + n - 1) - 'a');


    }

}