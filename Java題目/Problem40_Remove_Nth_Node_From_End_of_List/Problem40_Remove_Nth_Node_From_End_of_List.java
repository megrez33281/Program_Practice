/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
package Problem40_Remove_Nth_Node_From_End_of_List;
import java.util.*;
import javax.print.DocFlavor;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.IntStream;


public class Problem40_Remove_Nth_Node_From_End_of_List{

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode fifth = new ListNode(5);
        ListNode four = new ListNode(4,fifth);
        ListNode thr = new ListNode(3,four);
        ListNode sec = new ListNode(2);
        ListNode head = new ListNode(1,sec);

        ListNode sol = solution.removeNthFromEnd(head,1);
        while(sol !=null){
            System.out.println(sol.val);
            sol = sol.next;
        }




    }



}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int index = 0;
        ListNode transform = head;
        List<ListNode> lists = new ArrayList<>();
        while(transform.next != null){
            lists.add(transform);
            transform = transform.next;
            index++;}
        lists.add(transform);

        int target = index-n+1;//計算出要刪除的ListNode之索引

        //以target可能存在不同位置來做刪除
        if(target < index && target != 0){lists.get(target-1).next = lists.get(target+1);}//將索引為target-1之ListNode連結到索引為target+1之ListNode
        else if(target == 0 && index == 0){return null;}//回傳空值
        else if(target == 0){return lists.get(1);}
        else if(target == index){lists.get(target-1).next = null;}




        return lists.get(0);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}




