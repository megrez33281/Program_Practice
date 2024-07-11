/**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
package Problem50_Combination_Sum_II
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem50_Combination_Sum_II{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(solution.combinationSum2(candidates,8));


    }
}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        int pointer = candidates.length-1;
        //先將不可能的答案剔除
        while(pointer > 0 && candidates[pointer] > target){pointer--;}//剔除大於目標的數字
        int count = 0;
        //將重複的數字，其數量限制在相加後(重複數字相加)不大於目標
        while(pointer > 0){
            if(count+candidates[pointer] <= target){list.add(candidates[pointer]);}
            if(candidates[pointer] == candidates[pointer-1]){count+=candidates[pointer];}
            else{count = 0;}
            pointer--;
        }
        list.add(candidates[0]);
        int len = list.size();
        int[] NewCandidates = new int[len];
        for(int i=0; i<len; i++){
            NewCandidates[len-i-1] = list.get(i);}

        List<Integer> temp = new ArrayList<>();
        count(NewCandidates,target,len-1,ans,temp);
        return ans;
    }

    private void count(int[] candidates, int target, int pointer,List<List<Integer>> ans, List<Integer>temp){
        if(target > 0  && pointer >=0 && candidates[pointer]*(pointer+1) >= target){

                List<Integer> tempI = new ArrayList<>(temp);
                count(candidates,target,pointer-1,ans,tempI);//不選
                List<Integer> tempII = new ArrayList<>(temp);
                target-= candidates[pointer];
                tempII.add(candidates[pointer]);
                 count(candidates,target,pointer-1,ans,tempII);//選

        }

        else if(target == 0 && !ans.contains(temp)){
            ans.add(temp);}
    }


}


