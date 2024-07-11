/**

 */
package stu_110502018;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class E1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.permute(nums));



    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutations(nums, ans, list, nums.length);
        return ans;
    }

    private void permutations(int[] nums, List<List<Integer>> ans, List<Integer> list, int end) {

        if (list.size() == end){
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

