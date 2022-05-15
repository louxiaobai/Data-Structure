package com.leedcode.dayEight;

/**
 * @author lqw
 * @date 2022/4/4-12:12 下午
 */

public class _1539_FindKthPositive {

    public static void main(String[] args) {

        int[] arr=new int[]{2};

        System.out.println(findKthPositive(arr, 2));

    }

    /**
     * 思路:使用二分查找
     * 因为数组是有序递升的--使用二分查找中间的值和对应的索引进行比较 arr[mid]-mid-1 如果大于零说明 前面缺失了元素
     * 找到第一个 arr[mid]-mid-1>=k的值
     * 则可以知道 num= k-(arr[mid-1]-(mid-1)-1)为 指向arr[mid-1]时候还缺少的个数
     * arr[mid-1]+num-就是所指的最后一个元素
     * arr[mid-1]+(k-arr[mid]-mid-1)-则是要找的最后一个缺失的元素
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive(int[] arr, int k) {

        //进行特殊判断

        if (arr[0]>k) return k;

        int left=0;

        int right=arr.length;//因为可能最后一个值还没有找到arr[mid]-mid-1>k的值 此时需要将left-1指向最后一个值 所以arr.length不能减去一

        //2 3 4 7 11 13--k=100
        //找到最后一个缺失的值 1

        while (left<right){

           int  mid=left+(right-left)/2;
            if ((arr[mid]-mid-1<k)){//使用mid和和nums中mid所指的元素进行比较--不相等则说明发生了缺失
                 left=mid+1;
            }else {
                 right=mid;
            }

        }

        int missCount=arr[left-1]-(left-1)-1;

        int num=arr[left-1]+(k-missCount);

        return num;
    }

    /**
     * 暴力解法 直接进行模拟
     * 思路:定义一个 currNum 表示正常应该出现的数字,用currNum和数组中的值进行对比如果 相等 则 currNum+=,i++
     * 如果不相等则说明发生了缺失,此时应该让 currNum++, 同时记录最后出现的currNum,
     * 注意:nums如果 超出了 数组的范围 则不让 i进行++了
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositive1(int[] arr, int k) {

        int currNum=1;

        int lastNum=-1;

        int i=0;
        while (k>0){

            if (currNum==arr[i]){//如果相等 说明没有缺失

                if (i<arr.length-1) i++;//如果找到数组的末尾 缺失的值还是每找完则 i 无需进行++操作了


            }else {//如果不等说明发生的了缺失

                k--;

                lastNum=currNum;

            }
            currNum++;


        }

        return lastNum;


    }

}