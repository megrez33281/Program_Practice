/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
package Problem73_Subsets;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem73_Subsets{

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.subsets(nums));

    }
}
//解法：利用遞迴找到所有組合，遞迴時以index作為基準向右添加新元素
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ans.add(temp);
        combination(nums,ans,temp,-1);
        return ans;
    }

    private void combination(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index){

        if(temp.size() <= nums.length){
            for(int i = index+1; i<nums.length; i++){
                List<Integer> tem = new ArrayList<>(temp);
                tem.add(nums[i]);
                ans.add(tem);
                combination(nums,ans,tem,i);
            }
        }
    }
}