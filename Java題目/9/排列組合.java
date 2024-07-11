/**
 有1、2、3、4個數字，能組成多少個互不相同且無重複數字的三位數？都是多少？
 */
package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

      int sum = 0;

      //將所有位數限制在1~4
      for(int bite=1; bite<5; bite++){
          for(int ten=1; ten<5; ten++){
              for(int hundred=1; hundred<5; hundred++){
                  if(bite != ten && bite != hundred && ten != hundred){
                      System.out.println(hundred*100 + ten*10 + bite);
                      sum++;
                  }
              }
          }
      }

      System.out.println("共有" + sum + "個數字");

    }
}

