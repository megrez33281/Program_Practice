/**
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
 */
package Problem69_Set_Matrix_Zeroes;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem69_Set_Matrix_Zeroes{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] temp = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(temp);
        for(int[] i: temp){
            for(int j: i){System.out.print(j + " ");}
            System.out.println();
        }

    }
}
//遍歷matrix，若該行含有0，則將該行全改為0，且紀錄其列，之後再將被記錄的列都改為0
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        int len = matrix.length;
        int wid = matrix[0].length;
        for(int i=0; i<len; i++){
            int judge = 0;
            for(int j=0; j<wid; j++){
                if(matrix[i][j] == 0){
                    row.add(j);
                    judge = 1;}}
            if(judge == 1){matrix[i] = new int[wid];}
        }
        for(int i=0; i<len; i++){
            for(int j:row){
                matrix[i][j] = 0;
            }
        }

    }
}