/**
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
 */
package Problem52_Jump_Game_II;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem52_Jump_Game_II{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1,2,1,1,1,1};
        System.out.println(solution.jump(nums));



    }
}
class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int count = 0;
        while(cur < nums.length-1){
            int max_step = cur + 1;
            if(cur + nums[cur] >= nums.length-1){count++;break;}
            for(int i=cur+1; i <= Math.min(cur + nums[cur],nums.length-1); i++){
                if(nums[i]+i-cur >= nums[max_step] + max_step-cur){//找到當前移動的距離加上移動到的下一個座標能移動距離和的最大值之座標
                    max_step = i;}}
            cur = max_step;
            count++;

        }
        return count;
    }


}


