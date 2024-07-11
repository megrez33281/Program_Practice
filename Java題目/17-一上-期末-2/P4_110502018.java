/**
 Practice 4
 Student Number : 110502018
 Coures: 2022-CE1004-B
 */
package com.company;
import javax.print.DocFlavor;
import java.lang.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Vector;




public class P4_110502018{

    public static void main(String[] args) {

        try{
        FileReader file = new FileReader("input.txt");
        BufferedReader bf = new BufferedReader(file);
        StringBuilder content = new StringBuilder();
        String line = "";
        while((line = bf.readLine()) != null){content.append(line);}
        file.close();
        char[] vol = content.toString().toCharArray();
        StringBuilder bin_list = new StringBuilder();
        String plus = "";
        for(char i :vol){
            int acs = Integer.valueOf(i);
            String bin_str = Integer.toBinaryString(acs);
            if(bin_str.length()<8){
                int l = 8-bin_str.length();
                for(int n=0; n<l; n++){bin_str = "0" + bin_str;}}

            bin_list.append(bin_str);}
        int len = bin_list.length();
        if(len % 6 == 4){
            bin_list.append("00");
            plus = "=";}
        else if(len %6 == 2){
            bin_list.append("0000");
            plus = "==";}


        len = bin_list.length();

        for(int i=0; i*6<len; i++){
            bin_list.insert(i*6+i,"@");}
        String[] list = bin_list.toString().split("@");
        int[] value = new int[len/6];
        int k=0;
        for(String i:list){if(!i.equals("")){
            value[k] = Integer.parseInt(i,2);
            k++;}}
        StringBuilder ans = new StringBuilder();
        for(int i:value){ans.append(number_to_char(i));}
        ans.append(plus);
        System.out.println(ans);//print


        FileWriter output = new FileWriter("output.txt");
        BufferedWriter bf_out = new BufferedWriter(output);
        bf_out.write(ans.toString());
        bf_out.flush();
        bf_out.close();

        }
        catch(IOException e){System.out.println(e);}


        }

    private static char number_to_char(int number){

        char[] list = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};

        return list[number];
    }





    }