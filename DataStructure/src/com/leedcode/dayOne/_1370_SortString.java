package com.leedcode.dayOne;

/**
 * @author lqw
 * @date 2022/1/23-11:51 上午
 */
public class _1370_SortString {

    public String sortString(String s) {

        //先将字符按照ASCLl码存放在数组中

        int[] chars=new int[26];

        for (char c : s.toCharArray()) {

            chars[c-'a']++;
        }


        StringBuffer sb  = new StringBuffer();

        while (sb.length()<s.length()){


            //1.从s中选择一个最小的字符将他接在字符串的后面

            for (int i = 0; i < chars.length; i++) {


                if (chars[i]>0) {
                    sb.append((char) ('a' + i));
                    chars[i]--;
                }

            }


            //2.从s总选择一个最大的字符拼接到他的字符串后面


            for (int i = chars.length - 1; i >= 0; i--) {

                if (chars[i]>0) {
                    sb.append((char) ('a' + i));
                    chars[i]--;
                }

            }


        }

        return sb.toString();




    }


}