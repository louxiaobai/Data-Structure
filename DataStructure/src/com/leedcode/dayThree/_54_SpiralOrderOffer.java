package com.leedcode.dayThree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2022/2/18-9:43 上午
 */
public class _54_SpiralOrderOffer {

    /**
     * 不使用额外空间
     *时间复杂度:
     *空间复杂度:
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix){

            List<Integer> list=new ArrayList<>();

            int m=matrix.length;
            int n=matrix[0].length;

            int startRow=0;
            int endRow=m-1;
            int startCol=0;
            int endCol=n-1;

            while (startRow<=endRow||startCol<=endCol){


                for (int col = startCol; col <=endCol; col++) {//向右遍历

                    list.add(matrix[startRow][col]);

                }

                for (int row = startRow+1; row <=endRow ; row++) {//向下遍历

                    list.add(matrix[row][endCol]);

                }

                if (endCol>startCol&&endRow>startRow) {//只有一行或者一列 没必要走下面的

                    for (int col = endCol - 1; col >= startCol; col--) {//向左进行遍历

                        list.add(matrix[endRow][col]);

                    }

                    for (int row = endRow - 1; row > startRow; row--) {//向上进行遍历

                        list.add(matrix[row][startCol]);

                    }


                }



                startCol++;
                startRow++;
                endCol--;
                endRow--;


            }

            return list;

    }


    /**
     * 使用辅助空间
     * 空间复杂度O(m*n)
     * 时间复杂度O(m*n)
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder1(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int m=matrix.length;

        int n=matrix[0].length;

        //创建一个方向数组

        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};//分别为向右走,向下走,向左走,向上走

        //创建一个存储走过路径的数组

        boolean[][] res=new boolean[m][n];

        int row=0;
        int col=0;
        int di=0;//用来标记方式数组的位置
        for (int i = 0; i < m*n; i++) {

            list.add(matrix[row][col]);
            res[row][col]=true;//走过的标记为true

            //计算下一个位置

            int nexRow=row+direction[di][0];
            int nextCol=col+direction[di][1];

            if (nexRow<0||nexRow>=m||nextCol<0||nexRow>=n||res[nexRow][nextCol]){//需要换方向
                di=(di+1)%4;
            }
            row=row+direction[di][0];
            col=col+direction[di][1];
        }
        return list;
    }

}