package com.practical.string;

/**
 * @author lqw
 * @date 2022/3/1-11:35 上午
 */
public class BF {


    public static void main(String[] args) {

        BF bf1 = new BF();

        int index = bf1.indexOf("213", "111111213");

        System.out.println(index);

    }

    /**
     * 思路:比对 两个字符串中的每一个字符
     * 时间复杂度O(m*n)
     * 空间复杂度:O(1)
     * @param target
     * @param source
     * @return
     */
    public int indexOf(String target,String source ){

        if (target==null||source==null) return -1;

        int m= source.length();
        int n= target.length();
        
        if (m<n) return -1;
        
        //进行字符串的匹配

        for (int i = 0; i <= m-n; i++) {

            if (source.charAt(i)==target.charAt(0)){//如果相等则进行

                for (int j = 1; j <n ; j++) {

                    if (source.charAt(j+i)!=target.charAt(j)){

                        break;
                    }

                    if (j==n-1){

                        return i;

                    }


                }

            }

        }


        return -1;




    }







}