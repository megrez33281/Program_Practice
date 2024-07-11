/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
package Problem38_Letter_Combinations_of_a_Phone_Number;
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


public class Problem38_Letter_Combinations_of_a_Phone_Number{

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));


    }



}

class Solution {
    //以遞迴方式求解
    public List<String> letterCombinations(String digits) {

        int len = digits.length()-1;

        if(digits.equals("")){
            return new ArrayList<>();}
        List<String> lists = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for(int i=0; i<=len; i++){
            words.add(getLetter(digits.charAt(i)));}
        StringBuilder word = new StringBuilder();
        Combination(lists,words,0,word);

        return lists;
    }

    private  String getLetter(char digit){

        if (digit == '2') {return "abc";}
        else if (digit == '3') {return "def";}
        else if (digit == '4') {return "ghi";}
        else if (digit == '5') {return "jkl";}
        else if (digit == '6') {return "mno";}
        else if (digit == '7') {return "pqrs";}
        else if (digit == '8') {return "tuv";}
        else if (digit == '9') {return "wxyz";}
        else{return "error";}
    }

    private void Combination(List<String> lists, List<String> words, int now, StringBuilder word){

        if(now == words.size()){lists.add(word.toString());}

        else if(now < words.size()){
            for(int i=0; i<words.get(now).length(); i++){
                StringBuilder temp = new StringBuilder(word);
                temp.append(words.get(now).charAt(i));
                Combination(lists,words,now+1,temp);
            }
        }



    }
}






