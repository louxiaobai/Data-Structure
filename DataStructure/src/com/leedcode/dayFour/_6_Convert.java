package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/6-9:35 上午
 */
public class _6_Convert {
    /**
     *思路:用一个标识符来判断指针是向上移动还是向下移动,重点想到StringBuilder数组存储字符
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows==1) return s;

        StringBuilder[] sb=new StringBuilder[numRows];//根据给定的行数来创建一个字符串数组

        boolean flag=true;

        int index=0;

        //需要对数组进行初始化

        for (int i = 0; i < numRows; i++) {

            sb[i]=new StringBuilder();

        }

        for (char c : s.toCharArray()) {

            sb[index].append(c);

           if (index==0||(index==numRows-1) ){

               flag=!flag;
           }

            index+=flag?1:-1;

        }
        //对进行保存的StringBuilde进行遍历扫描

        StringBuilder res=new StringBuilder();
        for (int i = 0; i <numRows; i++) {

            res.append(sb[i]);

        }

        return res.toString();



    }


}