package com.leedcode.dayTen;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/4/14-10:52 上午
 */
public class _84_LargestRectangleAreaOffer {


    public static void main(String[] args) {

        int[] arr=new int[]{1,1};

        System.out.println(largestRectangleArea(arr));



    }


    /**
     * 使用单调栈+枚举高的方式求解
     *
     * 思路:求得 当前柱子的高度,并且求出比当前柱子低的左边和右边柱子的下标 则宽度为 (right-left-1)
     * 离当前 柱子最近的 比他低的柱子 用单调栈进行求解---对数据先进行预处理
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {


         //特值判断
        if (heights.length==1) return heights[0];

         //找到数组中左边第一个别它小的元素

        int[] leftMin=new int[heights.length];

        Arrays.fill(leftMin, -1);

        ArrayDeque<Integer> stack=new ArrayDeque<>();
        //从右往左边进行遍历找到第一个比当前值小的元素
        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){

                int index=stack.pop();
                leftMin[index]=i;
            }
            stack.push(i);
        }

        stack=new ArrayDeque<>();

        int[] rightMin=new int[heights.length];

        Arrays.fill(rightMin, heights.length);


        //从左往右进行遍历元素
        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int index=stack.pop();
                rightMin[index]=i;

            }

            stack.push(i);


        }



        int maxArea=0;
       //只在 柱子升高的时候计算最大面积--单调栈+枚举高
       for (int i = 0; i < heights.length; i++) {

            int height=heights[i];

            int width=rightMin[i]-leftMin[i]-1;


            maxArea=Math.max(maxArea, height*width);

     }

        return maxArea;

    }






}