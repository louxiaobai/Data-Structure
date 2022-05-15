package com.leedcode.twopoint;

import java.util.Arrays;

/**双指针算法--快慢指针
 * @author lqw
 * @date 2021/9/24-9:12 上午
 */
public class MoveZeroes {


    public static void main(String[] args) {

        int[] arr=new int[]{1,0,2,0,3,1,0};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 双指针解法
     * @param arr
     */

    public  static  void  moveZeroes(int[] arr){

        if (arr==null||arr.length==0){

            return;
        }

        int slow=0;

        for (int fast=0;fast<arr.length;fast++){

            if (fast==slow){//减少交换次数
                continue;
            }
            if (arr[fast]!=0){
                //进行快慢指针交换
                int tmp=arr[fast];
                arr[fast]=arr[slow];
                arr[slow]=tmp;

                slow++;

            }

        }

    }

    public  static  void  moveZeroes2(int[] arr){

        if (arr==null||arr.length==0){

            return;
        }

        int slow=0;

        for (int fast=0;fast<arr.length;fast++){

            if (fast==slow){//减少交换次数
                continue;
            }
            if (arr[fast]!=0){
                 //进行复制操作减少交换次数

                 arr[slow]=arr[fast];
                slow++;

            }

        }

        for (;slow<arr.length;slow++){

            arr[slow]=0;

        }

    }





}