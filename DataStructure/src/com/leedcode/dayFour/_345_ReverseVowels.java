package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/2-11:29 下午
 */
public class _345_ReverseVowels {


    /**
     * 对撞指针
     * @param s
     * @return
     */
    public String reverseVowels(String s) {


        if (s.length() == 1) return s;

        int left = 0;
        int right = s.length() - 1;

        //将字符串转换成字符数组

        char[] chars = s.toCharArray();

        while (left < right) {

            while (left<right&&!isVowel(chars[left])){

                left++;
            }

            while (right>left&&!isVowel(chars[right])){

                right--;
            }

            char temp = chars[left];

            chars[left] = chars[right];

            chars[right] = temp;

            left++;

            right--;


        }
        return new String(chars);

    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}