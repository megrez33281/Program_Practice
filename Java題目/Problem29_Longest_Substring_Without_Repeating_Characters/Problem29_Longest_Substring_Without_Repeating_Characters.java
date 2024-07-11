/**
Given a string s, find the length of the longest substring without repeating characters.
 */

package com.company;
import com.sun.jdi.IntegerValue;

import java.io.IOException;
import java.lang.String;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Problem29_Longest_Substring_Without_Repeating_Characters{


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));


    }

}


class Solution {
    public int lengthOfLongestSubstring(String s) {


        int longest = 0;
        for(int j=0; j<s.length(); j++){
            StringBuilder subString = new StringBuilder();
            for(int i=j; i<s.length(); i++){
                if (!subString.toString().contains(s.charAt(i) + "")) {
                    subString.append(s.charAt(i));

                }
                else{break;}
                if(subString.length() > longest){
                    longest = subString.length();}


            }}
        return longest;
        }

    }
