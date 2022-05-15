package com.leedcode.dayTwelve;


import java.util.HashMap;

/**
 * @author lqw
 * @date 2022/4/25-4:25 下午
 */
public class _567_CheckInclusionOffer {


    /**
     * 滑动窗口+数组：因为只出现了小写字母,故这里可以创建一个大小为26的数组,如果不确定出现多少中字符
     * 这里可以使用hashMap来进行替代,
     * 1.先统计每个字符的位置以及数目
     * 2.进行遍历s2字符串,并切对sourceArr进行操作 遍历到一个字符则对 出现在数组的位置进行减1操作
     * 如果减1之后出现了负数,说明这个区间不可能是包含s1的区间,此时让left进行++,并且执行+1操作
     * 知道 right所指元素的的位置不为负数
     * 3.如果right-left+1==s1.length() 则说明进行匹配成功返回true
     * 时间复杂度:O(m*n)
     * 空间复杂度:O(n)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2){

        //进行特判
        if (s1.length()>s2.length()) return false;
        //因为只包含26个小写字母,故只需要创建一个大小为26的数组
        int[] sourceArr=new int[26];
        //统计每个字符的位置以及数目
        for (int i=0;i<s1.length();i++){
            int num=s1.charAt(i)-'a';
            sourceArr[num]++;
        }
        int left=0;
        int right=0;
        while (right<s2.length()){

            //对在窗口出现的值进行--操作
            int num=s2.charAt(right)-'a';
            sourceArr[num]--;
            //如果数组中的值出现了负数说明字符串不能够进行匹配上
            while (sourceArr[num]<0){
                sourceArr[s2.charAt(left)-'a']++;
                left++;
            }
            //说明找到了匹配的字符串
            if (right-left+1==s1.length()){
                return true;
            }
            right++;
        }
        return false;
    }


    /**
     * 滑动窗口+hashMap
     * 思路:
     * 1.将s1出现的字符和出现字符的个数存储到hashmap中
     * 2.对全部的窗口进行遍历操作-出现的窗口数为s2.length-s1.length+1
     * 3.每次取和s1长度相等的窗口 s2.substring(i, i+s1.length())=t;
     * 4.在创建一个临时的hashmap存储窗口内的值,如果两个hashmap相等则说明匹配成功
     * 时间复杂度:O(t*n)
     * 空间复杂度:O(m*n^2)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {


        HashMap<Character,Integer> map=new HashMap<>();


        for (int i = 0; i < s1.length(); i++) {

            char c=s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left=0;

        int right=0;

        //长度为m-n+1
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {

            String str=s2.substring(i, i+s1.length());

            HashMap<Character,Integer> temMap=new HashMap<>();


            for (int j = 0; j <str.length() ; j++) {

                temMap.put(str.charAt(j),temMap.getOrDefault(str.charAt(j),0)+1);
            }

            //时间复杂度:O(n)
            if (temMap.equals(map)) return true;

        }

        return false;
    }
}