/**
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
 */
package Problem62_Insert_Interval
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem62_Insert_Interval{

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] intervals = {{1,3},{6,9}};
        int[] insert = {2,5};
        int[][] temp = solution.insert(intervals,insert);
        for(int[] i: temp){
            for(int j: i){System.out.print(j + " ");}
            System.out.println();
        }


    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){return new int[][]{newInterval};}
        //newInterval在頭部
        else if(newInterval[1] < intervals[0][0] ){
            int[][] newIntervals = new int[intervals.length+1][2];
            newIntervals[0] = newInterval;
            for(int i=1; i<newIntervals.length; i++){
                newIntervals[i] = intervals[i-1];}
            return newIntervals;}
        //newInterval在尾部
        else if(intervals[intervals.length-1][1] < newInterval[0]){
            int[][] newIntervals = new int[intervals.length+1][2];
            for(int i=0; i<newIntervals.length-1; i++){newIntervals[i] = intervals[i];}
            newIntervals[newIntervals.length-1] = newInterval;
            return newIntervals;
        }

        int start = 0;
        int end = 0;
        for(int i=0; i<intervals.length; i++){
            if(newInterval[0] >= intervals[i][0]){start = i;}
            if(newInterval[1] >= intervals[i][1]){end = i;}}

        //插入
        if(newInterval[0] > intervals[start][1] && newInterval[1] < intervals[end][0] && end - start == 1){
            int[][] newIntervals = new int[intervals.length+1][2];
            for(int i=0; i<newIntervals.length; i++){
                if(i < end){newIntervals[i] = intervals[i];}
                else if(i == end){newIntervals[i] = newInterval;}
                else{newIntervals[i] = intervals[i-1];}}
            return newIntervals;
        }

        //融合
        else{
            //確認融合的段落
            if(newInterval[0] > intervals[start][1]){start++;}//newInterval在start對應位置的段落外
            if(end + 1 < intervals.length && newInterval[1] >= intervals[end+1][0]){end++;}//newInterval在end+1位置內

            int[][] newIntervals = new int[intervals.length-end+start][2];
            for(int i=0; i<newIntervals.length; i++){
                if(i < start){newIntervals[i] = intervals[i];}
                else if(i == start){
                    newIntervals[i] = new int[]{Math.min(intervals[start][0],newInterval[0]),Math.max(intervals[end][1],newInterval[1])};}
                else{newIntervals[i] = intervals[i+end-start];}}

            return  newIntervals;
        }
    }
}
