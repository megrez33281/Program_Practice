/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
package Problem36_3Sum;
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


public class Problem36_3Sum{

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList<>();

        int[] num = {-2,0,1,1,2};
        System.out.println(solution.threeSum(num));

    }



}

class Solution {
    /*
    排序後，
    使用迴圈便歷，每一回圈以當前目標為之陣列值為主，去尋找兩個相加後等於0-該陣列值之數字(如此三數相加後為0)
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] newNum = Arrays.stream(nums).sorted().toArray();
        for(int i=0; i<newNum.length-2; i++){
            if(i==0 || (newNum[i] != newNum[i-1])){//一道篩選，避免尋找相同答案，且因為經過排序由小到大開始找，故得到的答案皆為由小到大，不會出現重複，後續不需要再篩選答案
            int left = i + 1;
            int right = newNum.length-1;
            int target = newNum[i]*-1;

            while(left < right){
                int now = newNum[left] + newNum[right];
                if(now != target && newNum[left] == newNum[right]){break;}
                if(now > target){
                    right--;
                }
                else if(now < target){
                    left++;
                }
                else {
                    ArrayList<Integer> num = new ArrayList<>();
                    num.add(newNum[i]);
                    num.add(newNum[left]);
                    num.add(newNum[right]);
                    list.add(num);
                    //if(!list.contains(num)){list.add(num);}
                    while(left < right && newNum[left+1] == newNum[left]){left++;}
                    while(left < right && newNum[right-1] == newNum[right]){right--;}
                    left++;
                    right--;//避免找到相同答案，當left和right指向的值皆不同時，i指向的值也不同
                }



            }}
        }

        return  list;
    }


    }






