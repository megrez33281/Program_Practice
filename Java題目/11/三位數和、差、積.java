/**
 撰寫一個程式讀入一個介於100 - 999的數字，然後顯示它的每位數和、積和差。例如932的每位數和是14、每位數積是54、每位數差是4。(百位數減十位數再減個位數)
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("請輸入一個介於100~999的數字：");
        int number = input.nextInt();

        if(number >= 100 && number <= 999){
            int[] num_arr = new int[3];
            for(int i=0; i<3; i++){
                num_arr[2-i] = number%10;
                number  = (number - number%10)/10;}
            int sum = num_arr[0] + num_arr[1] + num_arr[2];
            int diff = num_arr[0] - num_arr[1] - num_arr[2];
            int product = num_arr[0]*num_arr[1]*num_arr[2];
            System.out.println("每位數和=" + sum);
            System.out.println("每位數差=" + diff);
            System.out.println("每位數積=" + product);

        }

        else
            {System.out.println("輸入錯誤，結束程式");}

    }
}



