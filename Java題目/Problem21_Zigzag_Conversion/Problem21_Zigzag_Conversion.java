/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */
package Problem21_Zigzag_Conversion;
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



public class Problem21_Zigzag_Conversion{

    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            String word = input.next();
            int row = input.nextInt();
            Vector<String> list = new Vector<>();

            if(row >=2){
                int R = row -1;

                int i = 0;
                int len = word.length();
                word += "          ";
                for(int x=0; i<len; x++){
                    StringBuilder temp = new StringBuilder();
                    if(x%R == 0){
                        for(int j=0; j<=R; j++){
                           temp.append(word.charAt(i) );
                            i++;}
                    }
                    else{
                        for(int j=0; j<=R; j++){
                            if(j == R-x%R){
                                temp.append(word.charAt(i));
                                i++;}
                            else{temp.append(" ");}

                        }}

                    list.add(temp.toString());
                }


                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < row; j++){
                    for (String s : list) {
                        stringBuilder.append(s.charAt(j));
                    }
                }

                String answer = stringBuilder.toString().replace(" ","");
                System.out.println(answer);}

            else{
                System.out.println(word);
            }



        }

    }



