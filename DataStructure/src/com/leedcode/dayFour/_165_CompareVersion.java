package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/4-12:05 下午
 */
public class _165_CompareVersion {

    public static void main(String[] args) {

        String s1="0.1";
        String s2="1";

        System.out.println(compareVersion(s1, s2));

    }


    /**
     * 思路:使用挨个字符的方式进行比较
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {


        char[] char1 = version1.toCharArray();

        char[] char2 = version2.toCharArray();

        int i1=0,i2=0;

        while (i1<char1.length||i1<char2.length){

            //先进行计算char1第一个点之前的数字只和

            int v1=0;

            while (i1<char1.length&&char1[i1]!='.'){

                v1=v1*10+char1[i1]-'0';
                i1++;
            }

            int v2=0;

            while (i2<char2.length&&char2[i2]!='.'){

                v2=v2*10+char2[i2]-'0';
                i2++;
            }

            if (v1!=v2) return v1>v2?1:-1;

            i1++;
            i2++;

        }


        return 0;


    }

    /**
     * 使用内置函数进行求解1.按照.对字符串进行分割,2.然后比较每个位置的数值大小
     * //时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion1(String version1, String version2) {

        //1.将version1和version2按照.进行分割

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        //2.得到两个不带.字符数组然后对其进行挨个字符比较

        int n1=s1.length;

        int n2=s2.length;


        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {

            int v1=i<n1?Integer.parseInt(s1[i]):0;

            int v2=i<n2?Integer.parseInt(s2[i]):0;

            if (v1!=v2){
                return v1>v2?1:-1;
            }

        }
        return 0;

    }
}