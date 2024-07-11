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
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,five);
        ListNode two = new ListNode(2,three);
        ListNode head = new ListNode(1,two);
        ListNode ans = solution.reverseBetween(three,1,2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right){return head;}
        ListNode temp = head;
        ListNode reverseHead = new ListNode(0);
        ListNode last = new ListNode(0);
        List<ListNode> list = new ArrayList<>();
        int index = 1;
        while(temp != null){
            if(index == left-1){
                reverseHead = temp;}
            if(index >= left && index <= right){list.add(temp);}
            if(index == right+1){last = temp;}
            temp = temp.next;
            index++;
        }
        ListNode reverse = new ListNode(0);
        temp = reverse;
        for(int i=list.size()-1; i>=0; i--){
            temp.next = list.get(i);
            temp = temp.next;
        }
        temp.next = null;

        if(left > 1){reverseHead.next = reverse.next;}
        else{head = reverse.next;}
        if(index > right+1){temp.next = last;}

        return head;
    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }