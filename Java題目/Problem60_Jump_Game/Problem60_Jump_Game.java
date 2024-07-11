/**
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 */
package Problem60_Jump_Game
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem60_Jump_Game{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {2,0,1,0,1};
        System.out.println(solution.canJump(nums));


    }
}
//解法：當nums中不含0，必可達終點，當nums中含0，檢查是否會被卡在0的位置上
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){return true;}
        else if(nums[0] == 0){return false;}
        List<Integer> zero = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == 0){zero.add(i);}}
        if(zero.isEmpty()){return true;}

        for(int i=0; i<zero.size(); i++){
            int index = zero.get(i);
            index--;
            while(index >= 0){
                if(nums[index] + index <= zero.get(i)){index--;}
                else{break;}}
            if(index < 0 ){return false;}
        }
        return true;

    }
}
