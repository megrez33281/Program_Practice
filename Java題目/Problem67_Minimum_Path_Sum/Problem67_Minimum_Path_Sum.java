/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
package Problem67_Minimum_Path_Sum;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem67_Minimum_Path_Sum{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] temp = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution.minPathSum(temp));

    }
}
//解法：以DP方式，找到從grid[0][0]到所有格子的最短距離
class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int wid = grid[0].length;
        int[][] dis = new int[len][wid];
        dis[0][0] = grid[0][0];
        for(int i=0; i<len; i++){
            for(int j=0; j<wid; j++){
                int up = 999;
                int left = 999;
                if(i -1 >= 0){up = dis[i-1][j];}
                if(j -1 >= 0){left = dis[i][j-1];}
                if(up != 999 || left != 999){
                    dis[i][j] = Math.min(up,left);
                    dis[i][j] += grid[i][j];}
                }}

        return dis[len-1][wid-1];
    }
}
