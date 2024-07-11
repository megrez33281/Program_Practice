/**
 Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 */
package Problem23_String_to_Integer;
import java.lang.String;
import java.util.Scanner;


public class Problem23_String_to_Integer {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String content = input.nextLine();
        String contentI = content.replace(" ","").replace("+","").replace("-","");

        try{
            int answer = Integer.parseInt(contentI);
            System.out.println(content.contains("-")?answer*-1:answer);
        }

        catch(Exception e){

            System.out.println(content.contains("-")?-Math.pow(2,31):Math.pow(2,31)-1);

        }


    }

}