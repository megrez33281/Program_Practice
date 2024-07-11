/**
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.
 */
package Problem79_Gray_Code;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem79_Gray_Code{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(1));

    }
}
//解法：由n=0和n=1可以看出，n每加1，其表現形式可以為原本的"串列最前面全加上0"和"原本串列前面全加上1後顛倒"兩者串聯，即為n+1的答案
class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();
        List<String> bin = new ArrayList<>();
        bin.add("0");
        bin.add("1");
        gray(bin,n);
        for(String i: bin){
            int num = Integer.parseInt(i,2);
            ans.add(num);
        }
        return ans;
    }

    private void gray(List<String> bin, int n){

        if(n > 1 ){
            List<String> NewBin = new ArrayList<>();
            for(String i:bin){
                String temp = 0 + i;
                NewBin.add(temp);
            }
            for(int i=bin.size()-1; i>=0; i--){
                String temp = 1 + bin.get(i);
                NewBin.add(temp);}
            bin.clear();
            bin.addAll(NewBin);
            gray(bin,n-1);
        }

    }
}