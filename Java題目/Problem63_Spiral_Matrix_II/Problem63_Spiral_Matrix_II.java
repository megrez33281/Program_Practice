/**
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.
 */
package Problem63_Spiral_Matrix_II
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem63_Spiral_Matrix_II{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] intervals = {{1,3},{6,9}};
        int[][] temp = solution.generateMatrix(3);
        for(int[] i: temp){
            for(int j: i){System.out.print(j + " ");}
            System.out.println();
        }


    }
}

class Solution {
    public int[][] generateMatrix(int n) {

       int[][] ans = new int[n][n];
       int start = 0;
       int i=0;
       int j=0;
       int number = 1;
        //繞圈
       while(n>0){
           i=start;
           j=start;
           //向右
           //正方形的上邊需要先填滿，若是每一邊都缺1格，當正方形邊常等於1時，會導致那一格填不到
           for(; j<n+start; j++){ans[i][j] = number; number++;}
           j--;
           //向下
           i++;
           if(j == start+n-1){
               for(; i<n-1+start; i++){ans[i][j] = number; number++;}
           }
           //向左
           if(i == start + n-1 && j == start+n-1){
               for(; j>start; j--){ans[i][j] = number; number++;}
           }
           //向上
           if(i==start + n-1 && j == start){
               for(; i>start; i--){ans[i][j] = number; number++;}
           }
           start+=1;
           n-=2;
       }
       return ans;
        }
    }
