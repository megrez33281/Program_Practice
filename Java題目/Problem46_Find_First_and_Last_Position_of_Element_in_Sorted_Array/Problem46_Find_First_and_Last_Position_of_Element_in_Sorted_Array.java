/**
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
 */
package Problem46_Find_First_and_Last_Position_of_Element_in_Sorted_Array;
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


public class Problem46_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {2,2};

        int[] ans = solution.searchRange(nums,3);
        System.out.println(ans[0]);
        System.out.println(ans[1]);


    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int len = nums.length;
        if(len > 0){
            int pointer = 0;
            while(pointer < len && nums[pointer] < target){pointer++;}
            if(pointer!=len && nums[pointer] == target){
                ans[0] = pointer;
                while(pointer <len && nums[pointer] == target){pointer++;}
                pointer--;
                ans[1] = pointer;}
        }


        return ans;
    }
}