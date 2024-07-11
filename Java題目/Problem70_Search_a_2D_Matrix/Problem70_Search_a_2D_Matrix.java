/**
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 */
package Problem70_Search_a_2D_Matrix;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem70_Search_a_2D_Matrix{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] temp = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(temp,13));

    }
}

//解法：從每一行第一個元素比較，找到目標可能存在的行數，再從該行開始找目標的位置
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = 0;
        while(column < matrix.length && matrix[column][0] <= target){
            if(matrix[column][0] == target){return true;}
            column++;}
        column--;
        if(column <0){return false;}
        int row = matrix[0].length-1;
        while(row > 0 && matrix[column][row] > target ){row--;}

        return matrix[column][row] == target;
    }
}