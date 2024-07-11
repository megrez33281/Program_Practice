/**
 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
package Problem22_Reverse_Integer;
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



public class Problem22_Reverse_Integer{

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

       try{
           int number = input.nextInt();
           String reverse = new StringBuilder().append(number).reverse().toString().replace("-","");
           int answer = Integer.parseInt(reverse);
           System.out.println((number < 0?answer*-1:answer));
       }


       catch(Exception e){System.out.println(0);}

    }

}