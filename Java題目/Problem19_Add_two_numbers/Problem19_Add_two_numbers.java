/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
package Problem19_Add_two_numbers;
import com.sun.jdi.IntegerValue;

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



public class Problem19_Add_two_numbers{

    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            String str1 = input.next();
            String str2 = input.next();
            StringBuilder ans = new StringBuilder();

            int len = Math.max(str1.length(),str2.length());
            for(int i=0; i< len; i++){
                if( i > str1.length()-1){
                    str1 += "0";}

                if( i > str2.length()-1){
                    str2 += "0";}
            }

            int next = 0;
            for(int i=0; i<len; i++){
                int sum = 0;
                sum += str1.charAt(i) + str2.charAt(i) - 96 + next;

                if(sum >=10){
                    next = 1;
                    sum%=10;}

                else{next = 0;}


                ans.append(sum);

            }
            if(next == 1){ans.append(next);}


            System.out.println(ans);












        }

    }



