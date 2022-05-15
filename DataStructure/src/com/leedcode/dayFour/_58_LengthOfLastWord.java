package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/3-5:04 下午
 */
public class _58_LengthOfLastWord {

    public static void main(String[] args) {

        _58_LengthOfLastWord lengthOfLastWord = new _58_LengthOfLastWord();

        String s="   fly me   to   the moon  ";

        System.out.println(lengthOfLastWord.lengthOfLastWord(s));


    }

    public int lengthOfLastWord(String s) {


        char[] chars = s.trim().toCharArray();

        int index=0;
        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i]!=' '){

                index++;
            }else {

                break;
            }
            
        }

        return index;


    }


}