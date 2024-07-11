/**
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
 */
package Problem37_3Sum_Closest;
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


public class Problem37_3Sum_Closest{

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList<>();

        int[] num = {0,0,0};
        System.out.println(solution.threeSumClosest(num,1));

    }



}

class Solution {
    /*
    排序後，
    使用迴圈便歷，每一回圈以當前目標為之陣列值為主，去尋找兩個相加後等於0-該陣列值之數字(如此三數相加後為0)
    * */
    public int threeSumClosest(int[] nums, int target){
        int[] newNum = Arrays.stream(nums).sorted().toArray();
        int nearest = nums[0] + nums[1] + nums[2];
        for(int i=0; i<newNum.length-2; i++){
            int left = i + 1;
            int right = newNum.length-1;
            while(left < right){
                int sum = newNum[i] + newNum[left] + newNum[right];
                if(sum == target){return target;}

                else if(sum > target){right--;}

                else {left++;}
                if(Math.abs(sum-target) < Math.abs(nearest-target)){nearest = sum;}

            }


        }

        return nearest;
    }


    }






