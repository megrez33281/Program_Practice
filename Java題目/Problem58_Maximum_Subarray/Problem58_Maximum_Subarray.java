/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
 */
package Problem58_Maximum_Subarray
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem58_Maximum_Subarray{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));


    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];//含當前元素之最大子陣列和
        int ans = nums[0];//最大子陣列和
        int index = 1;
        //假設已知nums中1~i-1陣列中最大的子陣列和，求1~i陣列中最大的子陣列和
        //假設(1~i)中包含i的最大子陣列為curr
        //假設(1~i)中最大子陣列和為ans
        //找到curr與ans進行比較
        //假設index=i，curr最初代表1~i-1中包含i-1的最大子陣列和
        //因此要找到包含i的最大子陣列和只須將curr+nums[i]與nums[i]進行比較，較大的即為當前的curr
        //將curr與ans比較，較大者即為1~i中的最大子陣列和(ans)
        //在此將index視為i，從0開始，遞增到nums.length-1後得到的ans即為答案
        while(index < nums.length){
            curr += nums[index];
            if(curr < nums[index]){
                //若curr加上當前元素後小於當前元素(等於時不影響總和)捨棄之前元素和，curr設為當前元素
                curr = nums[index];}
            if(curr > ans){ans = curr;}
            index ++;
        }

        return  ans;
    }
}
