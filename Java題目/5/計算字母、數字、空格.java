/**
 輸入一行字元，分別統計出其英文字母、空格、數字和其它字元的個數。
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String content = input.nextLine();
        char[] content_arr = content.toCharArray();
        int vol=0, num=0, space=0;

        for (char i : content_arr) {
            if ('a' < i && i < 'z') {
                vol++;
            } else if ('A' < i && i < 'Z') {
                vol++;
            } else if ('0' < i && i < '9') {
                num++;
            } else if (i == ' ') {
                space++;
            }

        }

        System.out.print("單字：" + vol + '\n' + "數字：" + num + '\n' + "空格：" + space);

    }
}
