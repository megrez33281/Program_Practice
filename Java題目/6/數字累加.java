/**
 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一個數字。例如2+22+222+2222+22222(此時共有5個數相加)，幾個數相加有鍵盤控制。輸出結果的形式如：2+22+222=246；
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        System.out.print("請輸入想要的數字：");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.print("請輸入想要的項目數量：");
        int n = input.nextInt();

        int[] array = new int[n];
        array[0] = number;
        int a=1;
        for( int i=1; i< n; i++){
            a*=10;
            array[i] = number*a + array[i-1];}

        int sum = 0;
        for( int i=0; i<n-1; i++){
           sum += array[i];
           System.out.print(array[i] + " + ");
        }
        sum += array[n-1];
        System.out.print(array[n-1] + " = ");
        System.out.println(sum);
    }
}

