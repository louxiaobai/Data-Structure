package com.leedcode.dayThree;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/2/18-6:57 下午
 */
public class _59_GenerateMatrix {


    /**
     * 时间复杂度O(n*n)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public  int[][] generateMatrix(int n) {


        int[][] matrix=new int[n][n];

        int startCol=0;
        int endCol=n-1;
        
        int statRow=0;
        
        int endRow=n-1;

        int index=1;
        for (int i = 0; i < n * n; i++) {

            for (int col = startCol; col <=endCol ; col++) {//从右向左进行遍历

                matrix[statRow][col]=index;
                index++;

            }

            for (int row = statRow+1; row <=endRow ; row++) {//从上向下进行遍历

                matrix[row][endRow]=index;
                index++;

            }

            if (n!=1) {

                for (int col = endCol - 1; col >= startCol; col--) {//从右向左遍历

                    matrix[endRow][col] = index;
                    index++;

                }

                for (int row = endRow - 1; row >statRow; row--) {//从下向上进行遍历

                    matrix[row][startCol] = index;
                    index++;

                }
            }

            startCol++;
            statRow++;
            endCol--;
            endRow--;

        }


        return matrix;


    }



}

