/**
Given an m x n matrix, return all elements of the matrix in spiral order.
 */
package Problem59_Spiral_Matrix
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem59_Spiral_Matrix{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] matrix= {{6,9,7}};
        System.out.println(solution.spiralOrder(matrix));


    }
}

class Solution {

    //將矩陣由外到內剝成多個矩形
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int len = matrix.length;//長
        int wid = matrix[0].length;//寬
        int start = 0;
        while(len >0 && wid > 0){
            int left = start;
            int right = start;
            //左到右
            for(; right< start + wid; right++){
                ans.add(matrix[left][right]);}
            right--;
            //上到下
            if(right == start + wid-1){
                for(left+=1; left< start + len; left++){
                    ans.add(matrix[left][right]);}
                left--;}
            //右到左
            if(left == start + len-1 && right == start + wid-1 && len > 1){//避免重複執行
                for(right-=1;right > start; right--){
                    ans.add(matrix[left][right]);}}
            //下到上
            if(left == start + len-1 && right == start && wid > 1){//避免重複執行
                for(; left > start; left--){
                    ans.add(matrix[left][right]);}}
            len-=2;
            wid-=2;
            start++;}


        return ans;
    }
}
