package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/2/20-11:45 上午
 */
public class _28_StrStr {


    public static void main(String[] args) {

        String s1="mississippi";

        String s2="mississippi";

        System.out.println(strStr(s1,s2));



    }


    /**
     * 暴力解法
     * 思路:进行挨个匹配
     * 时间复杂度:O(n*m)
     * 空间复杂度:O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle.length()==0) return 0;

        int m=haystack.length();

        int n=needle.length();
        boolean falg=false;
        for (int i = 0; i <=m-n; i++) {
            int index=0;
            for (int j = i; j <i+n ; j++) {
                 falg=true;
                 if (haystack.charAt(j)!=needle.charAt(index)){
                     falg=false;
                     break;
                 }
                 index++;
            }
            if (falg){
                return i;
            }
        }
        return -1;
    }

}