/**
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 */
package Problem48_Count_and_Say;
import java.lang.String;


public class Problem48_Count_and_Say{

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));

    }
}

class Solution {
    public String countAndSay(int n) {

        String ans = count(n,0,"1");
        return  ans;
    }

    private String count(int n , int now, String ans) {

         if(now < n-1){
            StringBuilder combine = new StringBuilder();
            int value = 1;
            int pointer = 0;
            while (pointer < ans.length()) {
                if (pointer + 1 < ans.length() && ans.charAt(pointer) == ans.charAt(pointer + 1)) {
                    value++;
                    pointer++;}
                else {
                    combine.append(value).append(ans.charAt(pointer));
                    pointer++;
                    value = 1;
                }
            }
            return count(n, now + 1, combine.toString());//遞迴
        }

         else{return ans;}


    }



}