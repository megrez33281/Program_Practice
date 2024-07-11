/**
 判斷101-200之間有多少個素數，並輸出所有素數。
 */
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        for(int i=101;i<=200;i++){
            if(number(i) != 0)
                {System.out.println(number(i));}}

        }

    private static int number(int number){

        for(int i = 2; i<number; i++){
            if(number % i == 0){
               return 0;}}
        return number;

    }
}

