/**
給予總電壓、可變電阻中移動點之電壓、總電阻，計算移動點兩邊的電阻
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        float v;
        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.print("請輸入總電壓：");
            v = input.nextFloat();
            if(v != -1){
                System.out.print("請輸入B點電壓：");
                float Vb = input.nextFloat();
                System.out.print("請輸入總電阻：");
                float R = input.nextFloat();

                float RII = (Vb*R);
                RII  = RII/v;
                float RI = R - RII;
                System.out.println("R1= " + RI + " Ω");
                System.out.println("R2= " + RII + " Ω");}
            else
                {break;}

        }
    }
}



