package com.leedcode.dayTwo;

/**
 * @author lqw
 * @date 2022/2/13-9:24 下午
 */
public class _860_LemonadeChange {


    public static void main(String[] args) {

        int[] arr={5,5,5,10,20};

        System.out.println(lemonadeChange(arr));
    }


    public static boolean lemonadeChange(int[] bills) {

        if (bills[0]>5) return false;//特判

        int countFive=1;//记录5元的个数

        int countTen=0;

        for (int i = 1; i < bills.length; i++) {

            if (bills[i]!=5&&countFive<1) return false;//不能进行找零

            if (bills[i]==5) countFive++;//出现面值5快不用找零

            if (bills[i]==10){//出现面值10块 countFive-1，countTen+
                countTen++;
                countFive--;
            }

            if (bills[i]==20){//出现面值为20的情况
                if (countTen>0){//如果有10快则用10块钱找零
                    countTen--;
                    countFive--;
                }else if (countFive>2){//没有10快判断有没有三张5快的
                    countFive-=3;
                }else {//前面两种条件都没有 则不能进行找零
                    return false;
                }
            }


        }
        return true;

    }


}