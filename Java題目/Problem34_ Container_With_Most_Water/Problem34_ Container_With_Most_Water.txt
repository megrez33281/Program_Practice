/**
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 Find two lines that together with the x-axis form a container, such that the container contains the most water.

 Return the maximum amount of water a container can store.

 Notice that you may not slant the container.
 */
package Problem34_ Container_With_Most_Water;
import java.util.*;
import javax.print.DocFlavor;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Vector;


//解法：從最大長度(橫向)開始，最左和最右分別設一個指標，每次移動較短的柱子之指標(往內移)，當移動到的柱子長度增加時方可能抵銷橫向減少的長度，使面積增加


public class Problem34_ Container_With_Most_Water{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] num = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(num));

    }



}

class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int right = height.length-1;
        int left = 0;

        while(right > left){
            int area = (right-left)*Math.min(height[right],height[left]);
            max = Math.max(max,area);
            if(height[right] > height[left]){left++;}
            else{right--;}

        }

        return max;
    }
}


