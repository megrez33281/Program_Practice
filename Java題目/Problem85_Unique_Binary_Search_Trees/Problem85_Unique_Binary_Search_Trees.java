/**
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
package Problem85_Unique_Binary_Search_Trees;
import com.sun.source.tree.Tree;

import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Problem85_Unique_Binary_Search_Trees{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));

    }
}

//解法：以DP方式得出1~n的解，套用公式f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ...... + f(n-1)*f(0)
class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

}





