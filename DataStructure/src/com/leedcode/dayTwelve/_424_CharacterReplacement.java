package com.leedcode.dayTwelve;


import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author lqw
 * @date 2022/5/2-8:34 下午
 */
public class _424_CharacterReplacement {



    /**
     * 滑动窗口+数组
     * 思想:求窗口内的最多字母,因为题目条件限制为了大写字母故只需要进行创建一个26个大小的数组进行存放出现的字符即可
     * 1.初始化一个left 和right 进行标记滑动窗口的大小,将right经过的字符存储到数组中
     * 2.如果出现窗口内的总的字符的个数减去最多字符的个数>k则说明窗口过大,包含了不符合条件的数据，需要对窗口进行缩小 left--
     * 3.满足一一次条件则进行计算一个最大值,知道right=s.length();
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @param k
     * @return
     */
    public  int characterReplacement(String s, int k) {



        int left=0;
        int right=0;
        int res=0;
        int[] cnt=new int[26];// 用于26个大写字母计数
        while (right<s.length()){
            int rightIndex=s.charAt(right)-'A';//得到right对应的数
            cnt[rightIndex]++;//对字符进行计数
            while (!check(cnt, k)){//如果不满足 则需要缩小窗口
                int del=s.charAt(left)-'A';
                cnt[del]--;
                left++;
            }
            //求最大值
            res=Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
    public boolean check(int[] cnt,int k){

        int max=0;//存储最最多的字符
        int sum=0;//记录字符的总数


        for (int i = 0; i < cnt.length; i++) {

            max=Math.max(max, cnt[i]);
            sum+=cnt[i];

        }

        //如果总数减去最大值 大于 k的数量 说明不满足窗口求最大值，需要进行缩小窗口
        return sum-max<=k;



    }
}