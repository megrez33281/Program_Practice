/**
 打印出所有的"水仙花數"，所謂"水仙花數"是指一個三位數，其各位數字立方和等於該數本身。例如：153是一個"水仙花數"，因為153=1的三次方＋5的三次方＋3的三次方。
 */
//三位數範圍為100~999
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        for(int i=100; i<=999; i++){
            if(judge(i) == 1) {
                System.out.println(i);}
            }
    }
    private static int judge(int number){

        int num = number;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += (number % 10) * (number % 10) * (number % 10);
            number = (number - (number % 10)) / 10; }

        if (sum == num) {
            return 1; }
        else {
            return 0;}

    }

}