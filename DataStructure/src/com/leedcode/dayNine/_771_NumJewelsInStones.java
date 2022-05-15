package com.leedcode.dayNine;


import java.util.HashSet;

/**
 * @author lqw
 * @date 2022/4/5-10:27 上午
 */
public class _771_NumJewelsInStones {


    /**
     * //用数组代替哈希表
     * 时间复杂度:O(n)
     * 空间复杂度:O(58)=O(1)
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {


        int[] arr=new int[58];//这里为什么使用58呢,大小写字母一共才56个,因为在大写和小写字母之间 存在 6个字符


        for (char c : jewels.toCharArray()) {

            arr[c-'A']=1;

        }

        int sum=0;

        for (char c : stones.toCharArray()) {

            sum+=arr[c-'A'];

        }

        return sum;


    }

    /**
     *使用哈希表进行存储和查找
     * 时间复杂度:O(n)
     * 空间复杂度:O(m)
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones2(String jewels, String stones) {


        HashSet<Character> hashSet = new HashSet<Character>();


        for (int i = 0; i < jewels.length(); i++) {

            hashSet.add(jewels.charAt(i));

        }

        int sum=0;

        for (int i = 0; i <stones.length() ; i++) {


            if (hashSet.contains(stones.charAt(i))){

                sum++;

            }



        }



        return sum;



    }


    /**
     * 暴力解法:进行挨个对比
     * 时间复杂度:O(m*n)
     * 空间复杂度:O(1)
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones1(String jewels, String stones) {

        int sum=0;
        for (int i = 0; i < stones.length(); i++) {

            for (int j = 0; j < jewels.length(); j++) {

                if (stones.charAt(i)==jewels.charAt(j)){


                    sum++;

                }
            }
        }

        return sum;
    }
}