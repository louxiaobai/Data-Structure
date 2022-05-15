package com.leedcode.daySix;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/3/29-10:15 上午
 */
public class _75_SortColorsTop100 {


    public static void main(String[] args) {
        _75_SortColorsTop100 sortColorsTop100 = new _75_SortColorsTop100();

        int[] arr=new int[]{2,0,2,1,1,0};

        sortColorsTop100.sort(arr);

        System.out.println(Arrays.toString(arr));
    }



    public void sortColors(int[] nums) {

        //进行特殊判断
        if (nums.length==1) return;

        //进行快速排序

    }

    /**
     * 快速排序的应用:
     * 时间复杂度:o(n)
     * 空间复杂度:O(1)
     * @param data
     */
    public void sort(int[]data) {


        int less = 0;
        int great = data.length - 1;
        int i = less;

        while (i <= great) {

            if (data[i] < 1) {

                int temp = data[i];
                data[i] = data[less];
                data[less] = temp;
                i++;
                less++;
            }
            if (data[i] > 1) {

                int temp = data[i];
                data[i] = data[great];
                data[great] = temp;
                great--;

            } else {

                i++;

            }


        }

    }

}