/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
package Problem51_ Multiply_Strings
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem51_ Multiply_Strings{

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.multiply("123","456"));



    }
}
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>();
        //-48
        for(int i=num2.length()-1; i>=0; i--){//num2
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            for(int j=num1.length()-1; j>=0; j--){
                int count = (num1.charAt(j)-48)*(num2.charAt(i)-48) + carry;
                carry = count/10;
                count%=10;

                temp.insert(0,count);}
            temp.insert(0,carry);
            for(int k=i; k>0;k--){temp.insert(0,0);}
            list.add(temp);
        }
        ans.append(list.get(0));
        for(int i=1; i<list.size(); i++){
            int carry = 0;
            int count;
            for(int j=list.get(i).length()-1; j>=0; j--){
                count = carry + (ans.charAt(j)-48) + (list.get(i).charAt(j)-48);
                carry = count/10;
                count %= 10;
                ans.replace(j,j+1,count+"");}
        }
        while(ans.length() >1 && ans.charAt(0) == '0'){ans.delete(0,1);}


        return  ans.toString();
    }
}


