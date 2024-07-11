/**
 String to Integer (atoi)
 前面所有空白省略，後第一個字元若非正負號或數字回傳0
 Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

 The algorithm for myAtoi(string s) is as follows:

 Read in and ignore any leading whitespace.
 Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 Return the integer as the final result.
 */
package stu_110502018;
import java.util.*;
import javax.print.DocFlavor;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Vector;





public class Problem33_String_To_Integer{

    public static void main(String[] args) {


       Solution solution = new Solution();
       System.out.println(solution.myAtoi("words and -987"));



    }



}


class Solution {
    public int myAtoi(String s) {

        int index = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        while(index < n && s.charAt(index) == ' '){index++;}

        if(index < n && s.charAt(index) == '-'){
            sign = -1;
            index++;

        }
        else if(index < n && s.charAt(index) == '+'){
            sign = 1;
            index++;
        }

        while(index < n && Character.isDigit(s.charAt(index))){

            int digit = s.charAt(index) - '0';

            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = result*10 + digit; //必須放在if後面，不然會計算成(result*10 + digit)與(digit)之結果
            index++;

        }

        return result*sign;

    }
}

