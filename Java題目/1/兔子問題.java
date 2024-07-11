/**
 古典問題：有一對兔子，從出生後第3個月起每個月都生一對兔子，小兔子長到第三個月後每個月又生一對兔子，假如兔子都不死，問每個月的兔子對數為多少？
 */
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("請輸入想知道兔子數量的月份：");
        Scanner input = new Scanner(System.in);
        int months = input.nextInt();
        System.out.printf("該月份共有%s對兔子",fun(months));

    }


    private static int fun(int months){
        //遞迴數列(a1 = 2, a2 = 2, an = an-1 + an-2 )
        if(months == 1 || months==2)
            {return 1;}
        else
            {return fun(months-1) + fun(months-2);}
    }
}
