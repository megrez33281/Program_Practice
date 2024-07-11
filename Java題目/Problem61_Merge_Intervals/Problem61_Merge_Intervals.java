/**
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
package Problem61_Merge_Intervals
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem61_Merge_Intervals{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] intervals = {{2,9}, {1,3}, {8, 17}, {15, 18}};
        int[][] temp = solution.merge(intervals);
        for(int[] i: temp){
            for(int j: i){System.out.print(j + " ");}
            System.out.println();
        }


    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//將intervals依頭排序


        return mer(intervals);
    }

    public int[][] mer(int[][] intervals){
        int judge = 0;
        int last = 0;
        List<int[]> tem = new ArrayList<>();
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                if(i+1 == intervals.length-1){last = 1;}
                int[] temp = {Math.min(intervals[i][0],intervals[i+1][0]),Math.max(intervals[i][1],intervals[i+1][1])};
                tem.add(temp);
                judge = 1;
                i+=1;}
            else{
                tem.add(intervals[i]);
            }}
            if(last == 0){tem.add(intervals[intervals.length-1]);}
            if(judge == 0){return intervals;}
            else{
                int[][] temp = new int[tem.size()][];
                for(int i=0; i< temp.length; i++){temp[i] = tem.get(i);}
                return mer(temp);
            }

    }
}
