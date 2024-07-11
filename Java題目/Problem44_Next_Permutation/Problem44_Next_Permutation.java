/**
 permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
package Problem44_Next_Permutation
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


public class Problem44_Next_Permutation{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {5,1,1};
        solution.nextPermutation(nums);
        for(int i: nums){System.out.println(i);}

        }



    }

class Solution {
    public void nextPermutation(int[] nums) {
        //由後往前找到第一個後面的數字大於前面的數字，假設其位置分別為x,x+1，在x+1和nums.length-1範圍內由後往前尋找，找到第一個大於x位置之數字的數字，將兩者顛倒，之後再將x+1到nums.length-1範圍內數字顛倒
        int len = nums.length;
        int cur = len-1;
        int pre = cur-1;
        if(len > 1){
            while(nums[cur] <= nums[pre] && pre>0){
                cur--;
                pre--;}
            if(pre == 0 && nums[cur] <= nums[pre]){
                Arrays.sort(nums);
            }
            else{
                for(int i=len-1; i>pre; i--){

                    if(nums[i] > nums[pre]){
                        int temp = nums[pre];
                        nums[pre] = nums[i];
                        nums[i] = temp;
                        break;}}
                int[] tem = new int[len-cur];
                for(int j = len-1; j>pre; j--){
                    tem[len-1-j] = nums[j];}

                for(int j = cur; j<len; j++){
                    nums[j] = tem[j-cur];}
            }}



    }
}