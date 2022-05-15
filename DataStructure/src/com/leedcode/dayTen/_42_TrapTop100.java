package com.leedcode.dayTen;

import java.util.ArrayDeque;

/**
 * @author lqw
 * @date 2022/4/11-8:49 下午
 */
public class _42_TrapTop100 {


    public static void main(String[] args) {

        Integer i=10;

        Integer i1=new Integer(10);

        System.out.println(i==i1);


    }




    /**
     * 双指针解法
     *思路:主要是取得 当前元素 左边 和右边的最大 然后取两边的最小值(因为接水的多少取决与最矮的柱子)
     * 用两个变量来代替 元素 左边的 最大值 和元素 右边的最大值
     * 然后对比较 当前 左边和右边所指的指针那个小-如果 左边小于右边 则计算左边,相反的计算右边
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {

        //第一个柱子和最后一个柱子永远装不到水
        if (height.length<=2) return 0;
        //左右指针必须从两端开始因为两端可能是最大值
        int leftMax=0;
        int rifhtMax=0;
        int left=0;
        int right=height.length-1;
        int res=0;
        while (left<right){
            leftMax=Math.max(height[left],leftMax);
            rifhtMax=Math.max(height[right],rifhtMax);
            if (height[left]<height[right]){//如果左边的柱子低则按照左边的柱子进行计算--雨水的多少取决于柱子低的那根
                res+=leftMax-height[left];
                left++;
            }else {
                res+=rifhtMax-height[right];
                right--;
            }
        }
        return res;
    }
    /**
     * 使用单调栈进行求解
     * @param height
     * @return
     */
    public int trap1(int[] height) {

        if (height.length<=2) return 0;

        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int res=0;
        for (int i = 0; i < height.length; i++) {

            //如果栈不为空 且 当前元素 大于栈顶元素则进行计算 能盛多少水
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){

                int currHegiht=height[stack.pop()];//要计算的这个柱子能盛多少水

                if (stack.isEmpty()) break;//如果此时栈为空 则不进行计算

                int leftIndex=stack.peek();//左边的下表

                int Width=i-leftIndex-1;//能盛水宽度

                int Height=Math.min(height[leftIndex],height[i])-currHegiht;

                res+=Width*Height;
            }
            //不管如何都需要将元素i进行入栈

            stack.push(i);

        }

        return res;

    }

    /**
     * 暴力解法
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        //第一个柱子和最后一个柱子永远装不到水
        if (height.length<=2) return 0;

        //计算没根柱子装水多少,需要计算这个柱子的左边最大高度,和这个柱子的右边最大高度

        //计算左边最大高度
        int[] leftMax=new int[height.length];
        leftMax[0]=height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        //计算右边最大高度
        int[] rightMax=new int[height.length];
        rightMax[height.length-1]=height[height.length-1];
        for (int i = height.length-2; i>=0 ; i--) {
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        //对能接到多少水 进行计算
        int res=0;
        for (int i = 1; i < height.length-1; i++) {
            int left=leftMax[i];
            int right=rightMax[i];
            //能接的水取决与最矮的那根柱子所以要取最小值
            int maxHeight=Math.min(left, right);
            if (maxHeight>height[i]){//如果高度小于当前柱子高度则接不到水
                res+=maxHeight-height[i];
            }
        }
        return res;
    }

}