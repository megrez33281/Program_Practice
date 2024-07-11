/**
河內塔
 */
package com.company;
import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.util.Vector;



public class 河內塔{

    public static void main(String[] args){


        Hanoi(3,"A","B","C");
    }

    private static void Hanoi(int n, String start, String middle, String end){

        if(n == 1){
            System.out.println(start + end);
        }

        else{
            Hanoi(n-1,start,end,middle);//將由上至下n-1個盤子移到中間
            Hanoi(1,start,middle,end);//將起點的最後一個盤子移到終點
            Hanoi(n-1,middle,start,end);//以中間為起點將盤子移到終點
        }
    }
}


