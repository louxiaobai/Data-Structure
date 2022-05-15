package com.leedcode.daySeven;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lqw
 * @date 2022/3/29-3:59 下午
 */
public class _56_Merge {




    public int[][] merge(int[][] intervals) {

        //第一步先对每个二位数组的第一位进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);


        //第二步创建一个动态数组

        List<int[]> list = new ArrayList<int[]>();


        //第三步对原始二维数组进行遍历


        for (int i = 0; i < intervals.length; i++) {

            if (list.isEmpty()) {//如果动态数组为空则直接进行添加进去

                list.add(intervals[i]);

            } else {//如果动态数组不为空 则对其进行判断

                //取出动态数组的最大
                int leftNum = list.get(list.size() - 1)[1];

                //取出要存储数组的最小值
                int rightNum = intervals[i][0];

                if (leftNum >= rightNum) {//说明存在交集则进行合并

                    //修改动态数组的值

                    list.get(list.size() - 1)[1] = Math.max(leftNum, intervals[i][1]);

                } else {//说明不存在交集

                    list.add(intervals[i]);

                }
            }

        }
        return list.toArray(new int[list.size()][]);


    }


}