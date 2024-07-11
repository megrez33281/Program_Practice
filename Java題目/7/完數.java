/**
 一個數如果恰好等於它的因子之和，這個數就稱為"完數"。例如6=1＋2＋3.程式設計找出1000以內的所有完數。
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        for(int i=1; i<=1000; i++)
            {if(i == count(i)){System.out.println(i);}

            }
    }

    private static  int count(int number){

        int sum = 0;
        for(int i=1; i<=(number-1); i++){
            if((number % i )== 0)
                {sum += i;}}

        return sum;
    }
}

