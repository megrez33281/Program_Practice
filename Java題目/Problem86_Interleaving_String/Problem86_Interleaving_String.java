/**
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m non-empty substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.
 */
package Problem86_Interleaving_String;
import com.sun.source.tree.Tree;

import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Problem86_Interleaving_String{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}

//解法：以二維dp求解
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()){return false;}
        //ex："aabcc","dbbca","aadbbcbcac"
        //以二維dp求解，dp陣列中對應的行+列組成需求的字串，行與列分別代表s1與s2
        //陣列中往右時看s2
        //陣列中往左時看s1
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];//索引為0代表空字串
        dp[0][0] = true;//前面已過濾長不等時的狀況，當s1與s2皆為空時，s3也為空
        for(int i=1; i<=s2.length(); i++){
            dp[0][i] = s3.charAt(i-1) == s2.charAt(i-1) && dp[0][i-1];//若前一個為true且當前i-1值在s3與s2對應相同字母則為True，否則為false(s2與s3無法對應)
        }
        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][0];
        }

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                //若左邊為T，以當前dp[i][j]來看，其為往右達到dp[i][j]，故看s2對應字母是否等於s3對應字母
                //若上方為T，以當前dp[i][j]來看，其為往下達到dp[i][j]，故看s1對應字母是否等於s3對應字母
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }


        return dp[s1.length()][s2.length()];
    }

}




