package com.leedcode.dayFive;

/**
 * @author lqw
 * @date 2022/3/9-10:18 上午
 */
public class _1232_CheckStraightLine {


    public boolean checkStraightLine(int[][] coordinates) {


        //如果二维数组中只包含两个点 则肯定在一条直线上
        if (coordinates.length<3) return true;

        //获取到前两个点的坐标值-- 可以得出斜率-如果斜率相等则说明肯定在同一条直线上

        int x1=coordinates[0][0];
        int y1=coordinates[0][1];

        int x2=coordinates[1][0];
        int y2=coordinates[1][1];



        //对二维数组进行遍历

        for (int i = 2; i <coordinates.length ; i++) {

            int xi=coordinates[i][0];
            int yi=coordinates[i][1];

            if ((yi-y1)*(x2-x1)!=(y2-y1)*(xi-x1))  return false;//如果斜率不想等则返回false


        }

        return true;

    }

}