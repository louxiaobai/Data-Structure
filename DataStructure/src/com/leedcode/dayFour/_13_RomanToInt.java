package com.leedcode.dayFour;


import java.util.HashMap;

/**
 * @author lqw
 * @date 2022/3/5-12:14 下午
 */
public class _13_RomanToInt {


    public static void main(String[] args) {


        String s="LVIII";

        System.out.println(romanToInt(s));




    }

    /**
     *思路:本题的关键是如果前小后大则是需要减去前面的数,这就是需要两个指针去进行比较大小
     * 时间复杂度O(n)
     * 空间发复杂度O(n)
     * @param s
     * @return
     */

    public static int romanToInt(String s) {


        //1.使用hash表进行存储阿拉伯对应的数字信息

        HashMap<Character, Integer> map = new HashMap<>();


        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int pre=map.get(s.charAt(0));

        int sum=0;

        for (int i = 1; i < s.length(); i++) {
            int curr=map.get(s.charAt(i));
            if (pre<curr){
                sum-=pre;
            }else {
                sum+=pre;
            }
            pre=curr;
        }

        sum+=pre;

        return sum;

    }


}