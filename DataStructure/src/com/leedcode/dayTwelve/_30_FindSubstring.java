package com.leedcode.dayTwelve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lqw
 * @date 2022/4/25-3:37 下午
 */
public class _30_FindSubstring {


    /**
     * 使用hash+滑动窗口查找
     * 题目中 每个单词的长度是相等的,可以可以出现多次,考虑使用hashmap
     * 现将目标值中的单词全部存储到 hashmap中
     * 滑动窗口的个数为 s.length()-totalLen+1
     * 对每个窗口的字符按照 wordLen 的长度进行切分放入到 temHash中
     * 然后对 temHash 和 hash 进行对比 如果 相等则 记录当前下标
     * 时间复杂度:O(n*m)
     * 空间复杂度:O(n+m)
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {


        //记录每个单词出现的次数
        HashMap<String,Integer> hash=new HashMap<>();
        for (String word : words) {
            hash.put(word, hash.getOrDefault(word, 0)+1);
        }

        int wordLen=words[0].length();//每个单词的长度
        int len=words.length;//单词的个数

        int totalLen=wordLen*len;//总共单词的长度

        List<Integer> list=new ArrayList<>();

        //滑动窗口的大小 s.length()-totalLen+1

        for (int i = 0; i < s.length()-totalLen+1; i++) {

            //拿到字串

            String strSub=s.substring(i,i+totalLen);

            //创建一个hash 表存储 窗口内的 单词

            HashMap<String,Integer> tempHash=new HashMap<>();


            for (int j = 0; j <totalLen; j+=wordLen) {

                 String word=strSub.substring(j,j+wordLen);
                 tempHash.put(word, tempHash.getOrDefault(word, 0)+1);

            }

            if (hash.equals(tempHash)){//说明两个map相等

                list.add(i);
            }

        }
        return list;

    }
}

