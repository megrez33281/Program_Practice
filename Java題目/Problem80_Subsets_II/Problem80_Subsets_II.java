/**
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
package Problem80_Subsets_II;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem80_Subsets_II{

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        System.out.println(ans);

    }
}

//解法：以遞迴方式執行，每次遞迴都從上一次添加的數字右邊開始遞迴，須注意因為nums有重複數字，取子集合時也會取到重覆子集合，ans添加時需篩選
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        ans.add(subset);
        Arrays.sort(nums);
        SubSet(nums,0,ans,subset);
        return ans;

    }

    private void SubSet(int[] nums, int index, List<List<Integer>> ans, List<Integer> subset){

        if(index < nums.length){
            for(int i=index; i<nums.length; i++){
                List<Integer> temp = new ArrayList<>(subset);
                temp.add(nums[i]);
                if(!ans.contains(temp)){ans.add(temp);}
                SubSet(nums,i+1,ans,temp);//下一次遞迴從此次遞迴取的數字右邊第一個數字開始
            }
        }

    }
}