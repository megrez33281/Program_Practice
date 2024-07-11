/**
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the quotient is strictly less than -2^31, then return -2^31.
 */
package Problem43_Divide_Two_Integers
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
import java.util.stream.IntStream;


public class Problem43_Divide_Two_Integers{

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648,-1));

        }



    }

class Solution {
    public int divide(int dividend, int divisor) {
        long ans = 0;
        int sign = 1;
        long first = dividend;
        long sec = divisor;//long型別方便偵測是否超出Integer.MAX_VALUE 和 Integer.MIN_VALUE

        if(first == 0){return 0;}
        else if(first <0 && sec >0){sign = -1; first*=-1;}
        else if(first >0 && sec <0){sign = -1; sec*=-1;}
        else if(first <0 && sec<0){first*=-1; sec*=-1;}

        //以遞進方式除
        while(first >= sec){
            long temp = sec;
            long add = 1;
            for(int i=0; i<32; i++){
                if(temp*2 > first){
                    first -= temp;
                    ans += add;
                    if(ans >= Integer.MAX_VALUE){return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;}
                    break;
                }
                else{
                    temp*=2;//在temp大於first前，每次將temp乘二，之後ans要加的add也會隨之乘2
                    add*=2;}
            }

            if(ans*sign == Integer.MAX_VALUE){return Integer.MAX_VALUE;}
            else if(ans*sign == Integer.MIN_VALUE){return Integer.MIN_VALUE;}
        }


        return (int)ans*sign;
    }

}