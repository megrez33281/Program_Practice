/**
 題目：一球從h米高度自由落下，每次落地後反跳回原高度的一半；
 再落下，求它在 第n次落地時，共經過多少米？第n次反彈多高？
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("請輸入高度：");
        float height = input.nextFloat();
        System.out.print("請輸入第幾次落地：");
        int n = input.nextInt();

        int sum = 0;
        for(int i=0; i<n; i++)
            {if(i == 0){
                sum += height;}
             else
                {sum += height*2;}
             height *= 0.5;}
        System.out.println("第" + n + "次落地時：");
        System.out.println("共經過" + sum + "米");
        System.out.println("反彈" + height + "米");
    }
}

