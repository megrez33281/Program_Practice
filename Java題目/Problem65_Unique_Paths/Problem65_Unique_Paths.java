/**
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
package Problem65_Unique_Paths;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem65_Unique_Paths{

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(10,10));

    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        int right = n-1;
        int down = m-1;
        int total = right + down;
        double ans = 1;
        for(int i=total; i>Math.max(right,down); i--){ans*=i;}
        for(int i=Math.min(right,down); i>1; i--){ans/=i;}

        return (int)ans;
    }
}
