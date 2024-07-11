/**
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
package Problem45_Search_in_Rotated_Sorted_Array
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


public class Problem45_Search_in_Rotated_Sorted_Array{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1};
        System.out.println(solution.search(nums,3));


    }
}
class Solution {
    public int search(int[] nums, int target) {
        int pointer = 0;
        int ans = -1;
        int rotate = 0;
        int len = nums.length;

        while(rotate < len-1 && nums[rotate] < nums[rotate+1]){rotate++;}
        rotate++;

        if(rotate == len){
            while(nums[pointer] < target && pointer < len-1){pointer++;}
            if(nums[pointer] == target){ans = pointer;}}
        else if(target < nums[0] && target >= nums[rotate]){
            pointer = rotate;
            while(nums[pointer] < target && pointer < len-1){pointer++;}
            if(nums[pointer] == target){ans = pointer;}}
        else if(target >= nums[0]){
            while(nums[pointer] < target && pointer < rotate){pointer++;}
            if(nums[pointer] == target){ans = pointer;}
        }


        return ans;

    }
}