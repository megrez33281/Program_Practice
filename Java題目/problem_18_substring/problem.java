
package problem_18_substring;
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



public class problem{

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int longest = 0;
        String longest_str = "";

        for(int i=0; i<s.length(); i++){
            int scope = s.length();

            for(int j=i; j<s.length(); j++){
                int index = s.indexOf(s.charAt(j),j+1);
                int temp_length = (index == -1? s.length()-1-i : index - i);
                //System.out.println("起點為位於" + j + "的" + s.charAt(j) + " 包裹範圍: " +( temp_length));

                if(temp_length < scope){scope = temp_length;}
                //System.out.println("scope = " +scope);
            }




            if(scope > longest){
                //System.out.println("longest = " + longest + " scope = " + scope);
                longest = scope;
                longest_str = s.substring(i,i +scope);
            }
            //System.out.println("起點為 " + i + " 長度 = " + scope + "最大範圍 = " + longest +  "\n=========\n");
        }


        System.out.println(longest);
        //System.out.println(longest_str);

        }

    }



