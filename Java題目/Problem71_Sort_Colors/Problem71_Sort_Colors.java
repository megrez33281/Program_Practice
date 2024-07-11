/**
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
 */
package Problem71_Sort_Colors;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem71_Sort_Colors{

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temp = {};
        solution.sortColors(temp);
        for(int i:temp){System.out.print(i + " ");}

    }
}
//解法：紀錄三個顏色的數目後按順序將nums改造
class Solution {
    public void sortColors(int[] nums) {

        int[] color = new int[3];
        for(int i: nums){
            switch(i){
                case 0 -> color[0]++;
                case 1 -> color[1]++;
                default -> color[2]++;
            }
        }

        int index = 0;
        int colorIndex = 0;
        while(colorIndex < 3 && index < nums.length){
            if(color[colorIndex] > 0){
                nums[index] = colorIndex;
                color[colorIndex]--;
                index++;}
            else{
                colorIndex++;
            }
        }

    }
}