/**
 給予n個數字，將其由小到大排列。
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("請輸入數字，輸入-1結束");
        int number = 0,sum=0;
        String num_str = "";
        for(int i=0; number!=-1; i++){
            number = input.nextInt();
            if(number !=-1){
            num_str += number +"%";
            sum ++;}
            }
        char[] num_arr = num_str.toCharArray();

        String[] number_arr = new String[sum+1];
        number_arr[0] = "";
        for(int i=0,j=0; j<sum; i++){
            if(num_arr[i] == '%'){
                j++;
                number_arr[j] = "";}
            else
                {number_arr[j] +=  num_arr[i];}
        }
        for(int j=0; j<number_arr.length-1;j++){
            System.out.println(number_arr[j]);
        }


    }
}



