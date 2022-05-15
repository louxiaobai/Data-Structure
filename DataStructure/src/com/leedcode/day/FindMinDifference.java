package com.leedcode.day;

import java.util.Collections;
import java.util.List;

/**
 * @author lqw
 * @date 2022/1/18-9:19 下午
 */
public class FindMinDifference {

    public static void main(String[] args) {


    }


    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size()>1440) return 0;//雀巢原理 抽屉原理

        Collections.sort(timePoints);


        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
            ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }



    //对应的是ASCll表 0代表 48 1-代表49 依次类推-  减去0得到的是准确的数值
    public static int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');

    }


}