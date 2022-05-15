package com.leedcode.dayTwelve;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lqw
 * @date 2022/4/24-11:54 上午
 */
public class _3_LengthOfLongestSubstringTop {


    /**
     * 滑动窗口优化:定义一个left 和right指针,让right指针一直向前走 并且用hash表进行记录 right所走过的元素
     * 如果碰到重复元素 则让left走到重复元素的后一个元素, 每次while循环计算一下 窗口的大小,最后最长子串 的长度
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {



        if (s.length()<=1) return s.length();

        int res=1;

        HashMap<Character,Integer> window=new HashMap<>();
        int left=0;

        int right=0;
        while (right<s.length()){

            char rightChar=s.charAt(right);

            left=Math.max(left, window.getOrDefault(rightChar, 0));

            window.put(rightChar,right+1);//为什么加1 可以直接让left指向下一个元素
            res=Math.max(res, right-left+1);
            right++;

        }


        return res;








    }


    /**
     * 滑动窗口进行求解
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {


        if (s.length()<=1) return s.length();

        int res=1;

        Set<Character>  window=new HashSet<>();

        int left=0;

        int right=0;
        while (right<s.length()){
            char rightChar=s.charAt(right);
            //如果包含重复元素 则需要将left往前进行移动
            while (window.contains(rightChar)){
                window.remove(s.charAt(left));
                left++;
            }
            //不管怎么样都需要right所对应的元素进入hash表中
            res=Math.max(res, right-left+1);
            window.add(rightChar);
            right++;

        }
        return res;

    }
}