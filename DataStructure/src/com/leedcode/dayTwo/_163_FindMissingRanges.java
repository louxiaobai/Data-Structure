package com.leedcode.dayTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/13-12:02 下午
 */
public class _163_FindMissingRanges {

    /**
     * 时间复杂度度:O(n)
     * 空间复杂度O(1)
     * @param arr
     * @param lower
     * @param upper
     * @return
     */
    public  List<String> findMissingRanges(int[] arr,int lower,int upper){

        List<String> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i==0&&arr[i]>lower){
                if (arr[i]-1!=lower) {
                    list.add(String.valueOf(lower) + "->" + String.valueOf(arr[i] - 1));
                }else {
                    list.add(String.valueOf(lower));
                }
            }
            if (i+1<arr.length&&arr[i]+1!=arr[i+1]){
                if (arr[i+1]!=arr[i]+2){
                    list.add(String.valueOf(arr[i]+1)+"->"+String.valueOf(arr[i+1]-1));
                }else{
                    list.add(String.valueOf(arr[i]+1));
                }
            }
            if (i==arr.length-1){

                if (arr[i]<upper-1){

                    list.add(String.valueOf(arr[i]+1)+"->"+String.valueOf(upper));
                }else{

                    list.add(String.valueOf(upper));
                }



            }
            }

             return list;

            }

}








