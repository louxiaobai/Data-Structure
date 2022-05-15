package com.leedcode.dayThree;

import org.w3c.dom.html.HTMLIsIndexElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/20-10:23 上午
 */
public class _119_GetRow {




    /**
     * 滚动数组解法
     * 思路:杨辉三角的特点:下一行的值等于上一行的左右两边的值，等价成二维数组就是 等于上一行的 当前索引的值+当前索引-1的值
     * 滚动数组的思想就是行每加一次就是从后往前遍历一次。进行重置 部分的值,方式为:当前值=当前值+当前值的前一个值
     * 时间复杂度:O(n^2)
     * 空间复杂度O(k)
     * @param rowIndex
     * @return
     */
    public  static  List<Integer> getRow(int rowIndex){


        List<Integer> list=new ArrayList<>();
        list.add(1);//第一个值永远为1
        for (int row = 1; row <= rowIndex; row++) {
            list.add(0);//必须要做初始化一个值,不然会跑出越界异常
            for (int col = row; col>0 ; col--) {
                list.set(col, list.get(col)+list.get(col-1));
            }

        }

        return list;

    }
    /**
     * 暴力解法和上一题类似
     * 时间复杂度O(n^2/2)
     * 空间复杂度O(n^2/2)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {

        //1.先生成一个杨辉三角

        List<List<Integer>> list=new ArrayList<>();


        for (int i = 0; i <rowIndex+1; i++) {

            List<Integer> rowArr=new ArrayList<>();

            for (int j = 0; j <=i; j++) {

                if (j==0||j==i){


                    rowArr.add(1);

                }else {

                    List<Integer> preRow=list.get(i-1);

                    rowArr.add(preRow.get(j-1)+preRow.get(j));

                }


            }

            list.add(rowArr);

        }


        return list.get(rowIndex);





    }
}