/**
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
package Problem57_Pow(x, n)
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem57_Pow(x, n){

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.myPow(0.00001,2147483647));



    }
}

class Solution {
    public double myPow(double x, int n) {
        double number = x;
        if(n == 0) {return 1;}
        if(n < 0){
            n*=-1;
            x = 1/x;
            number = x;
        }
        n--;
        while(n > 0){
            long count = 1;
            double temp = number;
            while(count*2 < n && count < Integer.MAX_VALUE){
                temp*=temp;
                count*=2;}
            n-= count;
            x*=temp;}


        return x;
    }
}
