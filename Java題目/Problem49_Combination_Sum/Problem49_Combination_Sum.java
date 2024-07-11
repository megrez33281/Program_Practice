/**
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
package Problem49_Combination_Sum;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem49_Combination_Sum{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] candidates = {3,5,8};
        System.out.println(solution.combinationSum(candidates,11));


    }
}
/*解法:將candidates由小排到大，遍歷所有數字，以該數字為起點，進行遞迴，每次有三個選擇:選擇當前數字並往前、選擇當前數字並停留、不選擇當前數字並往前*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i=candidates.length-1; i>=0; i--){
            List<Integer> temp = new ArrayList<>();
            find(ans,temp,target,i,candidates);

        }

        return  ans;
    }

    private void find(List<List<Integer>> ans,List<Integer> temp,int target,int pointer, int[] candidates){
        if(target >0){
            target -= candidates[pointer];
            temp.add(candidates[pointer]);
            List<Integer> tempI = new ArrayList<>(temp);
            find(ans,tempI,target,pointer,candidates);
            if(pointer >0){
                List<Integer> tempII = new ArrayList<>(temp);
                List<Integer> tempIII = new ArrayList<>(temp);
                tempIII.remove(tempIII.size()-1);
                find(ans,tempII,target,pointer-1,candidates);
                find(ans,tempIII,target+candidates[pointer],pointer-1,candidates);}
        }
        else{
            if(target == 0 && !ans.contains(temp)){ans.add(temp);}
        }



    }
}