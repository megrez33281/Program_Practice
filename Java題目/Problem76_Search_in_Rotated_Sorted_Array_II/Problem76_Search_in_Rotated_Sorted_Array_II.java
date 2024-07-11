/**
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.
 */
package Problem76_Search_in_Rotated_Sorted_Array_II;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem76_Search_in_Rotated_Sorted_Array_II{

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};
        System.out.println(solution.search(nums,2));

    }
}

//解法；先比較nums[0]和target，若target較大，則從頭部開始往後找，當元素不再遞減(包含等於)或等於nums的最大範圍時停止，若target較小，則從尾部開始往回找，當元素不再遞增(包含等於)或等於index=0時停止
class Solution {
    public boolean search(int[] nums, int target) {

        if(nums.length == 0){return false;}
        if(target == nums[0]){
            return true;}

        else if(target > nums[0]){
            int index = 0;
            while(index < nums.length-1 && target > nums[index] && nums[0] <= nums[index]){index++;}//使得index不超出nums的範圍
            return (nums[index] == target);
        }

        else{
            int index = nums.length-1;
            while(index > 0 && target < nums[index] && nums[nums.length-1] >= nums[index]){index--;}//使得index不超出nums的範圍
            return (nums[index] == target);
        }

    }
}