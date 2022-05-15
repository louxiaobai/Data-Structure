package com.leedcode.dayTwelve;

/**
 * @author lqw
 * @date 2022/4/24-3:12 下午
 */
public class _76_MinWindow {


    /**
     * 解题思路:滑动窗口问题--需要匹配的是最小窗口,通过left和right指针进行查找到符合条件的窗口
     * 找到符合条件的窗口后将left指针进行左移动-每次都记录最小的窗口,直至窗口和目标值不匹配为止
     * 本题需要注意的是:需要借助额外的数组空间进行记录数据,创建一个大小为60的数组用来存储字符的位置
     * 流程:
     * 1.先记录 目标 值 不同的元素个数 以及 每个元素存放的为止
     *
     * 2.使用right指针 记录 窗口内的元素 如果 相同 位置下的元素的个数相等 则说明 匹配到一个字符,如果匹配的字符数等于目标值
     * 不同的元素个数则说明 当前的窗口 包含了目标值
     *
     * 3.此时需要进行缩小窗口的大小 并且进行记录窗口大小的最小值以及 窗口的具体位置
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if (s.length()<t.length()) return "";

        //因为仅有大写和小写字符组成-创建一个60位的数组--大写小写字母 共 52个 中间隔着8个其他字符

        int[] cntT=new int[60];

        //统计不同的字符
        int uniqueCharsInT = 0;
        //进行记录
        for (int i = 0; i < t.length(); i++) {
             char chatT=t.charAt(i);
             if (cntT[chatT-'A']==0) uniqueCharsInT++;
             cntT[chatT-'A']++;
        }

        //进行记录窗口的大小和窗口的起始位置
        int[] res=new int[]{-1,0,0};

        //窗口中每个字符出现的次数

        int[] windows=new int[60];

        //窗口中出现不同字符的次数

        int matchedChars = 0;

        int left=0;

        int right=0;

        while (right<s.length()){


            //出现的字符
            int rightChar=s.charAt(right);
            //出现字符的位置
            int rightCharIndex=s.charAt(right)-'A';

            windows[rightCharIndex]++;//窗口数据进行


            //如果说窗口内的元素的数量和目标值内某个元素的数量相等 则匹配字符数+1
            if (windows[rightCharIndex]==cntT[rightCharIndex]){
                matchedChars++;
            }

            while (matchedChars==uniqueCharsInT){
                //进行更新 以求最小窗口
                if (res[0]==-1||right-left+1<res[0]){
                    res[0]=right-left+1;
                    res[1]=left;
                    res[2]=right;
                }
                char leftChar=s.charAt(left);
                int leftCharIndex=leftChar-'A';
                windows[leftCharIndex]--;
                //如果窗口中当前位置的元素小于目标窗口当前位置的元素说明-个数不能够匹配上了。需要将 matchedChars 进行减1操作
                if (windows[leftCharIndex]<cntT[leftCharIndex]){
                    matchedChars--;
                }
                left++;
            }
            right++;

        }
        return res[0]==-1?" ":s.substring(res[1],res[2]+1);

    }
}