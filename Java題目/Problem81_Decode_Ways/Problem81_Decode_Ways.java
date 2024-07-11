/**

 */
package stu_110502018;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class E1{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));

    }
}

//解法：以DP方式得出每一長度字串的Decoding方法數
class Solution {
    public int numDecodings(String s) {

        //若是當前數字可以與前一數字拼接起來，代表list[i-2]中的所有方法都可以適用於兩數字拼接起來後，故list[i]+=list[i-2]
        //若是當前數字可以單獨存在，代表list[i-1]中的所有方法皆適用於list[i]，故list[i]+=list[i-1]
        if(s.charAt(0) == '0'){return 0;}
        int[] list = new int[s.length()+1];
        list[0] = 1;//使得for第一次回圈時，list[i-1]存在

        for(int i=1; i<list.length; i++){
            //由於要配合s的長度，以i-1為當前數字
            list[i] = (s.charAt(i-1) == '0')? 0:list[i-1];//當前數字為0，不可單獨存在
            if(i > 1 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <='6'))){list[i] += list[i - 2];}//前一數字為0時，必定不可拼接，故只考慮前一數字為1和2
        }
        return list[s.length()];

    }


}