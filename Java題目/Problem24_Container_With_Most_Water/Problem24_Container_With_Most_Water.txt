/**
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 Find two lines that together with the x-axis form a container, such that the container contains the most water.

 Return the maximum amount of water a container can store.

 Notice that you may not slant the container.
 */
package Problem24_Container_With_Most_Water;
import java.util.*;
import java.lang.String;
import java.util.Scanner;


public class Problem24_Container_With_Most_Water {

    public static void main(String[] args) {


       Scanner input = new Scanner(System.in);
       String temp = input.nextLine();
       String[] strings_array = temp.split(" ");
       ArrayList<Integer> num_list = new ArrayList<>();
        for (String s : strings_array) {
            if(!s.equals("")){
                num_list.add(Integer.parseInt(s + ""));}}

        int area = 0;
        int size = num_list.size();
        for(int start=0; start<size; start++){
            for(int end=start+1; end < size; end++ ){
                int tempArea = (end-start)*Math.min(num_list.get(end),num_list.get(start));
                //System.out.println(tempArea);
                if ( tempArea > area){area = tempArea;}


            }

        }


        System.out.println(area);


    }

}