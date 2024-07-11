/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
package Problem56_Group_Anagrams
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem56_Group_Anagrams{

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] list = {"a"};
        System.out.println(solution.groupAnagrams(list));



    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> compare = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String combine = Arrays.toString(temp);
            if(!compare.contains(combine)){
                compare.add(combine);
                List<String> tem = new ArrayList<>();
                tem.add(strs[i]);
                ans.add(tem);}
            else{
                int index = compare.indexOf(combine);
                ans.get(index).add(strs[i]);
            }
        }




        return ans;

    }
}
