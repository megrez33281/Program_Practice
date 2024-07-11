/**
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
 */
package Problem72_Combinations;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem72_Combinations{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4,2));

    }
}
//解法：先根據n列出所有數字，再以遞迴將其組合，遞迴時每次都只選擇List中最後一個元素對應到number中的位置之後的元素進行遞迴，來避免重複
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> number = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){number.add(i);}
        List<Integer> temp = new ArrayList<>();
        combination(number,ans,k,temp);
        return ans;
    }

    private void combination(List<Integer> number, List<List<Integer>> ans , int count, List<Integer> temp){

        if(temp.size() == count){
            ans.add(temp);
        }
        else{
            int last = (temp.size()==0)?0:temp.get(temp.size()-1);
            for(int i=last; i< number.size(); i++){
                List<Integer> tem = new ArrayList<>(temp);
                tem.add(number.get(i));
                List<Integer> newNumber = new ArrayList<>(number);
                combination(newNumber,ans,count,tem);
            }
        }


    }



    }