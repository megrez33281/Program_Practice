/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */

package Problem31_Zigzag_Conversion;
import com.sun.jdi.IntegerValue;

import java.io.IOException;
import java.lang.String;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Problem31_Zigzag_Conversion{


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.convert("A",1));



    }

}


class Solution {
    public String convert(String s, int numRows) {
        StringBuilder temp = new StringBuilder();
        temp.append(s);
        if(numRows <=1){return s;}
        int multiplier =numRows + (numRows-2);

        StringBuilder answer = new StringBuilder();
        StringBuilder[] list = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){list[i] = new StringBuilder("");}
        for(int i=0; i<temp.length(); i++){
            int index = (i%multiplier >numRows-1? (multiplier-(i%multiplier)):(i%multiplier));
            list[index].append(temp.charAt(i));
        }
        for(StringBuilder i: list){answer.append(i);}
        return answer.toString();
    }
}