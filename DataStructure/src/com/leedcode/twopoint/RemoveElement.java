package com.leedcode.twopoint;

import java.util.Arrays;

/**leedcode27号题---移除元素
 * @author lqw
 * @date 2021/9/26-3:57 下午
 */
public class RemoveElement {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6};

        System.out.println(removeElement2(arr, 2));

        System.out.println(Arrays.toString(arr));

    }

    /**普通方法
     * 进行移除数组中的元素
     * @param arr
     * @param val
     */
    public static int removeElement(int[] arr,int val){

        int k=0;

        for (int i = 0; i <arr.length ; i++) {

            if (arr[i]!=val){

                arr[k++]=arr[i];

            }

        }

        return k;
    }


    /**
     * 双指针解法
     * @param arr
     * @param val
     * @return
     */
    public static int removeElement2(int[] arr,int val){
        int slow=0;
        int fast=0;
        //进行遍历数组
        for (int data: arr){
            if (data!=val) {//如果data等于val则fast++
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }


}