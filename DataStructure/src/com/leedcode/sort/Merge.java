package com.leedcode.sort;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
/**合并区间--中等难度 56题
 * @author lqw
 * @date 2021/10/5-11:42 上午
 */
public class Merge {



    public static void main(String[] args) {

        int[][] arr={{1,3},{2,5},{9,10}};

        int[][] list=merge(arr);
        System.out.println(list[1][1]);

    }

    public static int[][] merge(int[][] intervals){

        //第一步按照 对二维数组按照 首位数字的大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //排序完成进行合并-自定义一个 动态数组存储 数据
        ArrayList<int[]> list=new ArrayList<int[]>();

        //对二维数组进行遍历
        for (int i = 0; i <intervals.length ; i++) {

            //如果list为空则直接进行存储 元素

            if (list.size()==0){
                list.add(intervals[i]);
            }else{

                //如果不为空则进行判断-是否进行合并元素

                //1.取出已经存的元素的最大值

                int currMax=list.get(list.size()-1)[1];

                //2.得到当前遍历元素的最小值

                int currMin=intervals[i][0];//

                //3.如果当前遍历元素的最小值,大于等于已存数组中的最大值 -则进行合并

                if (currMin<= currMax){

                    //进行修改元素
                    list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1], intervals[i][1]);
                }else{
                    list.add(intervals[i]);
                }



            }



        }


        return list.toArray(new int[list.size()][]);


    }


}