package com.leedcode.dayOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/1/23-10:52 上午
 */
public class _1002_CommonChars {

    public static void main(String[] args) {

        String[] str=new String[]{"bella","label","roller"};

        commonChars(str);


    }

    /**
     * 运用数字和字符的转换(Ascll码)
     * 时间复杂度O(n^2)
     * 空间复杂度o(1)
     * @param words
     * @return
     */
    public static List<String> commonChars(String[] words) {
            
        //创建一个数组-用来存储26位小写字符--

        //创建一个数组-用来存储26位小写字符--

        int[] minArr=new int[26];

        for (char aChar : words[0].toCharArray()) {

            //计算出每个字符在数组中的下标

            minArr[aChar-'a']++;

        }

        for (int i = 1; i < words.length; i++) {

            //创建一个数组进行存储26位小写字母
            int[] arr=new int[26];


            for (char aChar : words[i].toCharArray()) {

                //计算出每个字符在数组中的下标

                arr[aChar-'a']++;

            }

            //把两者的最小值进行存储

            for (int j = 0; j <minArr.length ; j++) {
                minArr[j]=Math.min(arr[j],minArr[j]);
            }

        }

        System.out.println(Arrays.toString(minArr));

        //将minArr中的复合条件的下标转成字符串

        //创建一个list进行存储

        List<String> list=new ArrayList<>();

        for (int i = 0; i < minArr.length; i++) {

            for (int j = 0; j <minArr[i] ; j++) {

                list.add(String.valueOf(((char)(i+'a'))));

            }
        }
        return list;

    }
}