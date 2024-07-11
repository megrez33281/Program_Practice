/**
 將一個正整數分解質因數。例如：輸入90,打印出90=2*3*3*5。
 */

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.print(number + " = ");
        while(number != fun(number))
            {System.out.print(fun(number) + " * ");
             number = number/fun(number);}
        System.out.println(number);
    }

    private static int fun(int number){

        if(number == 1){return 1;}
        for(int i=2; i<=number; i++)
            {if(number%i == 0)
                    {return i;}}
        return 0;
    }

}