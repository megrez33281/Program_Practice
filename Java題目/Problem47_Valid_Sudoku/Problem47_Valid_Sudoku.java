/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
package Problem47_Valid_Sudoku
import java.util.*;
import javax.print.DocFlavor;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.IntStream;


public class Problem47_Valid_Sudoku{

    public static void main(String[] args) {

        Solution solution = new Solution();
        char[][] quew = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(solution.isValidSudoku(quew));

    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //橫
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int temp = Integer.parseInt(board[i][j] + "");
                    if (nums[temp] != temp) {
                        nums[temp] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        //直
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int temp = Integer.parseInt(board[j][i] + "");
                    if (nums[temp] != temp) {
                        nums[temp] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }

        int[][] Nine = new int[9][10];
        //將數獨分為9個3*3正方形，分別編號0~8，根據編號計算出對應的i、j值得到相應格子的編號
        for(int num=0; num<9; num++){
            for(int i=(num/3)*3; i<(num/3)*3+3; i++){
                for(int j=(num%3)*3; j<(num%3)*3+3; j++){
                    if(board[i][j] != '.'){
                        int temp = Integer.parseInt(board[i][j] + "");
                        if(Nine[num][temp] != temp){Nine[num][temp] = temp;}
                        else{return false;}
                    }
                }

        }

        }
        return true;
    }
}