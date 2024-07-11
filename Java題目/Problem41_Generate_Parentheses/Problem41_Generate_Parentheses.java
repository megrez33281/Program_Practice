/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
package Problem41_Generate_Parentheses
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


public class Problem41_Generate_Parentheses{

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(8);
        System.out.println(ans);


    }



}
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        generate(ans, n, new char[n * 2], 0);

        return ans;
    }

    private void generate(List<String> ans, int n, char[] word, int index) {

        if (index == n * 2) {
            if (judge(word)) {//此方式為列出所有可能的排列，不會出現重複
                ans.add(new String(word));//char -> string
            }
        }
        else {

            word[index] = '(';
            generate(ans, n, word, index + 1);
            word[index] = ')';
            generate(ans, n, word, index + 1);

        }


    }


    private boolean judge(char[] word) {
        int balance = 0;
        for (char i : word) {
            if (i == '(') {
                balance++;}

            else{
                balance--;}
            if(balance <0){return false;}
        }

        return balance == 0;
    }

}
