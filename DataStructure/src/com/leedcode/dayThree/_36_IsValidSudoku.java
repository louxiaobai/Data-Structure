package com.leedcode.dayThree;

/**
 * @author lqw
 * @date 2022/2/15-4:58 下午
 */
public class _36_IsValidSudoku {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(n^2)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        //九宫格的位置判断
        //boxIndex=row/3+(col/3)*3;
        //创建三个数组用于辨别行和列以及每个九宫格出现的情况
        boolean[][] rows=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] boxs =new boolean[9][9];
        for (int i = 0; i <9; i++) {

            for (int j = 0; j <9; j++) {

                if (board[i][j]!='.'){
                    int nums=board[i][j]-'1';
                    //进行判断行
                    if (rows[i][nums]) return false;
                    else rows[i][nums]=true;

                    //进行判断列
                    if (cols[j][nums]) return false;
                    else cols[j][nums]=true;

                    //进行判断九宫格
                    int index=i/3+(j/3)*3;
                    if (boxs[index][nums]) return false;
                    else boxs[index][nums]=true;

                }

            }

        }
        return true;
    }



}