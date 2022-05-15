package com.leedcode.dayNine;


import java.util.*;

/**
 * @author lqw
 * @date 2022/4/7-12:11 下午
 */
public class _49_GroupAnagrams {


    public static void main(String[] args) {



    }

    /**
     * 用字符转换成数字拼接成字符串当作键进行保存
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String,List<String>> hashMap=new HashMap<>();

        for (String str : strs) {
            int[] count=new int[26];

            for (char c : str.toCharArray()) {

                count[c-'a']++;

            }

            //将count转换成数字字符当键

            String s = Arrays.toString(count);

            if (!hashMap.containsKey(s)) hashMap.put(s, new ArrayList<String >());

            hashMap.get(s).add(str);


        }


        return new ArrayList<>(hashMap.values());





    }


    /**
     * 使用hashMap值进行求解:遍历字符串 将字符串转换成 字符 然后进行排序 当做键:如果出现字符相同排序后 一定和键相同
     * 对键进行判断,如果不存在这个键 就用hashMap进行存储,同时把这个原字符串 保存到 HashMap中
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        HashMap<String,List<String>> hashMap=new HashMap<>();

        for (String str : strs) {

            //对str进行排序,然后让其充当键--如果字符串满足所有字符出现个数一样则排序完成后一定是一样的。

            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key=String.valueOf(chars);

            if (!hashMap.containsKey(key)) hashMap.put(key, new ArrayList<>());

            hashMap.get(key).add(str);

        }
        return new ArrayList<>(hashMap.values());


    }
}