/**
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */
package Problem83_Restore_IP_Addresses;
import javax.xml.stream.events.StartDocument;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Problem83_Restore_IP_Addresses{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("101023"));
        String temp = "25525511135";

    }
}

//解法：以遞迴方式，每次從s中最右邊的'.'開始往後至其索引+3(每一段不大於255)嘗試於其中加入'.',當加入3個點後判斷是否為有效地址
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() <= 3 || s.length() > 12){return ans;}
        combine(s,3,ans);

        return ans;
    }

    private void combine(String s, int k, List<String> ans){
        if(k == 0 && judge(s)){
            ans.add(s);
        }

        else{
            int tempIndex = 0;
            //取得最右邊的'.'的位置
            while(s.indexOf('.',tempIndex) != -1){
                tempIndex = s.indexOf('.',tempIndex)+1;
            }
            int index = (s.indexOf('.') == -1) ? 1:tempIndex+1;
            for(int i=index; i<s.length() && i<index+3; i++){
                StringBuilder temp = new StringBuilder(s);
                temp.insert(i,'.');
                combine(temp.toString(),k-1,ans);
            }
        }

    }

    private boolean judge(String s){
        String[] temp = s.split("\\.");
        if(temp.length != 4){return false;}

        for(String i: temp){
            if(i.charAt(0) == '0' && i.length() >1){return false;}
            int num = Integer.parseInt(i);
            if(num > 255 || num < 0){return false;}}

        return true;

    }

}


