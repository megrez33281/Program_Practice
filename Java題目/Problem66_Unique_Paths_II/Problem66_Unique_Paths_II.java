/**
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
package Problem66_Unique_Paths_II;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem66_Unique_Paths_II{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] temp = {{0,0,0}, {0,1, 0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(temp));

    }
}
//解法：以DP方式解題，將到每一格的方法數儲存，由於只能往右或往下，計算方法數只需將加上上方和左方的格子數
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int wid = obstacleGrid[0].length;
        int len = obstacleGrid.length;
        int[][] ans = new int[len][wid];
        if(obstacleGrid[0][0] == 1){return 0;}
        ans[0][0] = 1;
        for(int i=0; i<len; i++){
            for(int j=0; j<wid; j++){
                //若該格為1，不存在達到該路徑的方法
                if(obstacleGrid[i][j] != 1){
                    if(j -1 >=0){ans[i][j] += ans[i][j-1];}//加上左邊格子的方法數(若該點為障礙物，方法數為0)
                    if(i -1 >=0){ans[i][j] += ans[i-1][j];}//加上上邊格子的方法數(若該點為障礙物，方法數為0)
                }
            }

        }
        return ans[len-1][wid-1];
    }

}
