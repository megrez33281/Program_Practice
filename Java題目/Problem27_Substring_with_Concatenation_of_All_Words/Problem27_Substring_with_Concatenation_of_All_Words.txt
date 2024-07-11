/**
 Practice 10
 Student Number：110502018
 Course: 2022-CE1004-B
 */

package Problem27_Substring_with_Concatenation_of_All_Words;
import java.lang.String;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;



public class Problem27_Substring_with_Concatenation_of_All_Words{


    public static void main(String[] args) {

        Solution solution = new Solution();
        List<Integer> find = solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
        for(int i: find){System.out.print(i + " ");}



    }

}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {


        List<Integer> list = new ArrayList<>();
        int space = words[0].length();
        for(int i=0; i<s.length(); i++){
            String temp;
            if(i + space < s.length()){
                temp =  s.substring(i,i+space);}
            else{
                temp = (s.length()>1?s.substring(i):s);}
            for(String j: words){
                if(j.equals(temp) && judge(s,words,i) && !list.contains(i)){
                    list.add(i);}

                }


        }

        return list;

    }


    public boolean judge(String s , String[] words, int start){
        int space = words[0].length();
        int len = words.length*space;
        if(start + len > s.length()){
            return false;}
        String substring = s.substring(start,len+start);

        List<String> answer = Arrays.asList(words);
        List<String> collect = new ArrayList<>();

        for(int i=0; i<len; i+=space){
            String particular = substring.substring(i,i+space);
            if(answer.contains(particular)){collect.add(particular);}
            else{
                return false;}
        }
        Collections.sort(answer);
        Collections.sort(collect);


        return collect.equals(answer);

    }
}


