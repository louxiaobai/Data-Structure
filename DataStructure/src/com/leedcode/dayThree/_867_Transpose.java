package com.leedcode.dayThree;

import java.util.Arrays;

/**
 * @author lqw
 * @date 2022/2/14-9:48 上午
 */
public class _867_Transpose {


    /**
     * 时间复杂度:O(mn)
     * 空间复杂度O(mn)
     * @param matrix
     * @return
     */
    public static int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j]=matrix[j][i];
            }

        }
        return res;



    }


}