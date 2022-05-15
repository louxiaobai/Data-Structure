package com.leedcode.dayNine;


import java.util.*;

/**
 * @author lqw
 * @date 2022/4/8-3:31 下午
 */
public class _1122_RelativeSortArrayOffer {


    /**
     * 使用计数排序--数据不是太大的时候要考虑 看看能不能用到计数 排序思想
     *
     *思路:把arr1中的数当作键 存储在count中,然后遍历 arr2数组 把arr2中的值当作键放在 count中 看看值有多少个
     *有几个就遍历几个 按照序列存放在arr1中,其余不在arr2中的按照从0遍历count 将有值的数据 依次存储在arr1中
     * 时间复杂度:O(m*n)
     * 空间复杂度:O(1001)
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //最多有1001个数---考虑使用计数排序

        int[] count=new int[1001];

        //把arr1中的数当作键 存储在count中

        for (int i : arr1) {

            count[i]++;

        }
        int index=0;
        for (int i = 0; i < arr2.length; i++) {

            for (int j = 0; j <count[arr2[i]] ; j++) {

                arr1[index++]=arr2[i];

            }
            count[arr2[i]]=0;//对count数组进行至零操作

        }

        //将count数组余下的数进行存储

        for (int i = 0; i < count.length; i++) {

            for (int j = 0; j <count[i] ; j++) {

                arr1[index++]=i;

            }
        }


        return arr1;

    }

    /**
     * 使用自定义排序+hash表进行求解
     * 思路:将arr1,转换成list方便使用Collection.sort--进行自定义排序规则,将arr2,使用hash表进行存储起来
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param arr1
     * @param arr2
     * @return
     */

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        //将arr2存储在HashMap中

        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {

            map.put(arr2[i],i);

        }

        //将数组存储到list中 用于动态排序--Collections

        List<Integer> list=new ArrayList<>();

        for (int i : arr1) {

            list.add(i);
        }

        //升序返回负数 降序返回 正数
        Collections.sort(list, (x, y) -> {

            if (map.containsKey(x)){//如果包含x

                return map.containsKey(y)? map.get(x)-map.get(y):-1;
            }else {
                return map.containsKey(y)?1:x-y;

            }

        });

        int index=0;

        for (Integer integer : list) {

            arr1[index++]=integer;

        }
        return arr1;

    }
}