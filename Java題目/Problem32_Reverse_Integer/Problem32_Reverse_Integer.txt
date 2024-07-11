/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

package Problem32_Reverse_Integer;
import com.sun.jdi.IntegerValue;

import java.io.IOException;
import java.lang.String;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Problem32_Reverse_Integer{


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));



    }

}

class Solution {
    public int reverse(int x) {
        int answer = 0;
        while(x != 0){

            int pop = x%10;
            x /= 10;

            if(answer > Integer.MAX_VALUE/10 || (answer == Integer.MAX_VALUE/10 && pop > 7)) return 0; //2^31 = 2147483648
            if(answer < Integer.MIN_VALUE/10 || (answer == Integer.MIN_VALUE/10 && pop <-8)) return 0;

            answer = answer*10 + pop;
        }

        return answer;

    }
}