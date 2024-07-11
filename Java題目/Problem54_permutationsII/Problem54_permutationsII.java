/**
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
package Problem54_permutationsII
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem54_permutationsII{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1,1,2};
        System.out.println(solution.permuteUnique(nums));



    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutations(nums, ans, list, nums.length);
        return ans;
    }


    private void permutations(int[] nums, List<List<Integer>> ans, List<Integer> list, int end) {

        if (list.size() == end && !ans.contains(list)){
            ans.add(list);}

        else{
            for (int i = 0; i < nums.length; i++) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);

                int[] NewNum = new int[nums.length - 1];
                for (int j = 0; j < NewNum.length; j++) {
                    if (j < i) {
                        NewNum[j] = nums[j];}
                    else {NewNum[j] = nums[j + 1];}}

                permutations(NewNum, ans, temp, end);


            }

        }


    }

}

