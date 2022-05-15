package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/3-12:06 上午
 */
public class _541_ReverseStr {


    public static void main(String[] args) {

        _541_ReverseStr reverseStr = new _541_ReverseStr();

        String s=reverseStr.reverseStr("abcdefg",2);

        System.out.println(s);


    }
    /**
     * 思路:对撞指针
     * 时间复杂度O(kn)
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {


        if (s.length()==1) return s;


        char[] chars = s.toCharArray();

        for (int start = 0; start < s.length(); start=start+2*k) {

            int left=start;

            int right=Math.min(left+k-1, s.length()-1);

            while (left<right){

                char temp=chars[left];

                chars[left]=chars[right];

                chars[right]=temp;

                left++;
                right--;
            }


        }


        return new String(chars);




    }


}