/**
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
package Problem55_Rotate_Image
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem55_Rotate_Image{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);



    }
}
//解法：將矩陣中[i][j]與[j][i]交換後再將每一列(row)顛倒
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i < n-1; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int[] i : matrix){
            reverse(i);
        }

        //輸出矩陣
        /*for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){System.out.print(matrix[i][j]  + " ");}
            System.out.println();}*/



    }

    private void reverse(int[] list){
        int len = list.length;
        int time = len/2;
        for(int i=0; i<time; i++){
            int temp = list[i];
            list[i] = list[len-i-1];
            list[len-i-1] = temp;
        }
    }
}

