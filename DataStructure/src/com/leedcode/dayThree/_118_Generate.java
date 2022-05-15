package com.leedcode.dayThree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/20-9:33 上午
 */
public class _118_Generate {


    /**
     *杨辉三角
     * 思路:直接模拟,杨辉三角没行的最后一个和第一个都是一，其他的为 上一个数组的当前下标+上一个下表
     * 时间复杂度:O(n^2)
     * 空间复杂:O(1)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {


        List<List<Integer>> list=new ArrayList<>();


        for (int row = 0; row < numRows; row++) {

             //创建一个数组 存储每一行的元素

             List<Integer> rowArr=new ArrayList<>();

            for (int col = 0; col <=row; col++) {

                if (col==0||col==row){//第一个元素和最后一个元素的时候

                    rowArr.add(1);

                }else {

                    List<Integer> preRow=list.get(row-1);

                    rowArr.add(preRow.get(col-1)+preRow.get(col));
                }

            }
            list.add(rowArr);

        }

        return list;

    }



}