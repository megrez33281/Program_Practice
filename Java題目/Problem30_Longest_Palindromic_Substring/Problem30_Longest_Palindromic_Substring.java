/**
 Given a string s, return the longest palindromic substring in s.
 */

package Problem30_Longest_Palindromic_Substring;
import com.sun.jdi.IntegerValue;

import java.io.IOException;
import java.lang.String;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Problem30_Longest_Palindromic_Substring{


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));



    }

}


class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        StringBuilder temp = new StringBuilder();
        temp.append("@");
        for(int i=0; i<s.length(); i++){
            temp.append(s.charAt(i)).append("@");
        }

        for(int j=0; j<temp.length(); j++){

            for(int k=0; k<=j; k++){
                if(j+k >= temp.length()){break;}
                if(temp.charAt(j-k) == temp.charAt(j+k)){

                    if(2*k +1 > longest.length()){longest = temp.substring(j-k,j+k+1);}
                }
                else {break;}
            }


                }




        return longest.replace("@","");
        }

    }
