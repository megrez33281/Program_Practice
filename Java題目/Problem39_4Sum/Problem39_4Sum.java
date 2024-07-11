/**
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 */
package Problem39_4Sum;
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


public class Problem39_4Sum{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {2,2,2,2};
        System.out.println(solution.fourSum(nums,8));




    }



}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        if(nums.length <=3){return lists;}
        int[] newNum = Arrays.stream(nums).sorted().toArray();
        int len = newNum.length;

        for(int i=0; i<len-3; i++){
            if(i>0 && newNum[i-1] == newNum[i]){continue;}
            for(int j=i+1; j<len-2; j++){
                if(j >i+1 && newNum[j-1] == newNum[j]){continue;}

                int left = j+1;
                int right = len-1;
                while(left < right){
                    long sum = (long)newNum[i] + newNum[j] + newNum[left] + newNum[right];
                    if(sum == target){
                        lists.add(Arrays.asList(newNum[i] , newNum[j] , newNum[left] , newNum[right]));
                        while(left < right && newNum[right] == newNum[right-1]){right--;}
                        while(left < right && newNum[left] == newNum[left+1]){left++;}
                        right--;
                        left++;}

                    else if(sum > target){right--;}
                    else{left++;}

                }
            }
        }

        return  lists;
    }
}






