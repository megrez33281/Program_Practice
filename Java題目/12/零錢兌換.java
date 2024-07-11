/**
 設計一個程式，提示使用者輸入金額，將此金額以100元、50元、20元、10元、5元、1元六種貨幣組合出該金額。組合方式為依照面額由大至小的順序使用貨幣，且每種貨幣的數量為無限多，無法使用100元時才能使用50元，無法使用50元時才可以使用20元，依此類推。由螢幕輸出計算結果。輸出格式為六個數字，第一個數字代表用幾個100元、第二個數字表示用幾個50元，依此類推。
 例如: 輸入101，輸出: 1 0 0 0 0 1。
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("請輸入金額：");
        int dollars = input.nextInt();
        int hundreds = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        int one = 0;

        while(dollars > 0){

            if(dollars >= 100){
                dollars -= 100;
                hundreds++;}

            else if(dollars >= 50){
                dollars -= 50;
                fifty++;}

            else if(dollars >= 20){
                dollars -= 20;
                twenty++;}

            else if(dollars >= 10){
                dollars -= 10;
                ten++;}

            else if(dollars >= 5){
                dollars -= 5;
                five++;}

            else{
                dollars -=1;
                one++;}

            }

        System.out.println(hundreds + " " + fifty + " " + twenty + " " + ten + " " + five + " " + one);
    }
}



