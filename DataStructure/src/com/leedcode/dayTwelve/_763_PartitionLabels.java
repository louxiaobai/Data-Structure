package com.leedcode.dayTwelve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/4/28-11:40 上午
 */
public class _763_PartitionLabels {


    /**
     * 滑动窗口+数组
     * 1.利用数组存储每个元素出现的最远位置
     * 2.遍历数组中的每一个元素,计算出left-right的最大范围
     * 3.如果i==right则说明找到了一个片段进行存储
     * 4.进行返回数据
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {


        int[] distance=new int[26];

        //记录每个元素的最远位置
        for (int i = 0; i < s.length(); i++) {
            distance[s.charAt(i)-'a']=i;
        }

        List<Integer> res=new ArrayList<>();
        int left=0;
        int right=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            //如果遍历的元素不在范围内则对right进行更新-取最大值
            right=Math.max(right, distance[c-'a']);
            //说明找到了片段--如果遍历的元素和right重合
            if (i==right){
                res.add(right-left+1);
                left=right+1;
            }
        }

    return res;



    }



    /**
     * 滑动窗口--算法不够优雅
     * 时间复杂度:O()
     * 空间复杂度:O(1)
     * @param s
     * @return
     */
    public List<Integer> partitionLabels1(String s) {

        List<Integer> list=new ArrayList<>();


        int left=0;
        int right=0;
        int index=0;
        while (right<s.length()){
            //得到当前元素的最远位置
            right=farInde(s, s.charAt(right));
            index=left;
            while (left<s.length()&&left<right){
                //计算left所指元素的最远距离
                int distance=farInde(s, s.charAt(left));
                if (right<distance){
                    //出现新的最远距离将right更新至最远处
                    right=distance;
                }
                left++;
            }
            list.add(right-index+1);
            right++;
            left=right;
        }
        return list;
    }

    /**
     * 返回当前元素的最原位置的下标
     * @param s
     * @param c
     * @return
     */
    public int farInde(String s,char c){

        int index=0;

        for (int i = 0; i < s.length(); i++) {

            if (c==s.charAt(i)) index=i;

        }
        return index;
    }
}