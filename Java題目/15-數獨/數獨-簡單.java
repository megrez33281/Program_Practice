/**
數獨
 */
package com.company;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

       String sudo_str = read("sudo1");
       char[] sudo_one_arr = str_to_char(sudo_str);
       int[] all_number_sum = all_number_sum(sudo_one_arr);
       int[] possible_locate_sum = possible_locate_sum(sudo_one_arr);


       while(char_find(sudo_one_arr,' ') !=-1){
       for(int j=0; j<81; j++){
           if(sudo_one_arr[j] == ' '){
               char[] list = judge(sudo_one_arr, j);
               if(list.length == 1){
                  sudo_one_arr[j] = list[0]; }}}

       System.out.print("\n");
       print_the_sudo(sudo_one_arr);}

    }


    private static int char_find(char[] char_list, char search){

        for(int i=0; i<char_list.length; i++){

            if(char_list[i] == search){
                return i;}}

        return -1;

    }

    private static int char_find_sum(char[] char_list, char search){

        int sum = 0;
        for(char i:char_list){
            if(i == search){sum++;}}
        return sum;
    }

    private static int int_find(int[] int_list, int number){

        int sum;
        for(int i:int_list){
            if(i == number){
                sum = i;
                return sum;}}
        return -1;
    }

    private static int[] find_possible_number_in_affect_scope(char[] char_list, int locate){

        int x = (locate - locate%9);
        int y = locate%9;
        int x_nine = ((x/9) - ((x/9)%3))/3;
        int y_nine = (y - y%3)/3;
        int loc =  x_nine*27 + y_nine*3;
        int[] sum = {0,0,0,0,0,0,0,0,0};
        char[] locate_list = judge(char_list,locate);
        char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] all_locate = new int[81];
        for(int i=0; i<81; i++){all_locate[i] = 100;}

        int j=0;
        for(int i=0; i<9; i++){
            if(int_find(all_locate,x+i) == -1){
               all_locate[j] = (x+i);
               j++;}}
        for(int i=0; i<9; i++){
            if(int_find(all_locate,y + i*9) == -1){
                all_locate[j] = (y + i*9);
                j++;}}
        for(int i=0; i<3; i++){
            if(int_find(all_locate,loc + 9*i) == -1){
                all_locate[j] = (y + i*9);
                j++;}
            if(int_find(all_locate,loc + 1 + 9*i) == -1){
                all_locate[j] = (y + 1 + i*9);
                j++;}
            if(int_find(all_locate,loc + 2 + 9*i) == -1){
                all_locate[j] = (y + 2 +  i*9);
                j++;}}

        for(int i:all_locate){
            if(i != 100){
                char[] possible_list = judge(char_list,i);
                for(char k:possible_list){
                    if(char_find(locate_list,k) != -1){
                        loc = char_find(number,k);
                        sum[loc]++;}}}}

       return sum;


        }

    private static int[] possible_locate_sum(char[] char_list){

        int[] sum = {0,0,0,0,0,0,0,0,0};
        char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i=0; i<9; i++){
            for(int j=0; j<81; j++) {
                if(char_list[j] == ' ' && char_find(judge(char_list,j),number[i]) != -1){
                    sum[i]++;}}}


        return sum;

    }

    private static void print_the_sudo(char[] char_list){
        for(int i=0; i<81; i++){
            System.out.print(char_list[i]);
            if(i%9 == 8){System.out.print("\n");}
        }

    }

    private static  char[] str_to_char(String sudo_str){

        char[] sudo_one_arr_temp = sudo_str.toCharArray();
        char[] sudo_one_arr = new char[81];
        for(int i=0,j=0; i<sudo_one_arr_temp.length; i++){
            if(sudo_one_arr_temp[i] != '\n'){
                sudo_one_arr[j] = sudo_one_arr_temp[i];
                j++;}}
        return sudo_one_arr;
    }

    private static int[] all_number_sum(char[] char_list){

        int[] number_sum = new int[9];
        char[] number_arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i=0; i<9; i++){
            number_sum[i] = char_find_sum(char_list, number_arr[i]);  }
        return number_sum;
    }

    private static String read(String file_name){


        StringBuilder content = new StringBuilder();
        try{

            FileReader file_reader = new FileReader(file_name + ".txt");
            BufferedReader buffer_reader = new BufferedReader(file_reader);


            String fr;
            while((fr= buffer_reader.readLine()) != null){
                content.append(fr + '\n');
            }



        }

        catch(IOException error){System.out.println(error);}

        String contentI = content.toString();
        return contentI;
    }

    private static void write(String file_name, String content){

        try{

            FileWriter file_writer =  new FileWriter(file_name + ".txt");
            BufferedWriter buffer_writer = new BufferedWriter(file_writer);

            buffer_writer.write(content);
            buffer_writer.flush();
            buffer_writer.close();


        }

        catch(IOException error){System.out.println(error);}
    }

    private static char[] judge(char[] one_arr, int locate){

        StringBuilder horizontal_gap = new StringBuilder();

        int  x = (locate - locate%9);
        char[] horizontal = new char[9];
        for(int i = x; i<(x+9); i++){
            horizontal[i%9] = one_arr[i];}
        char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(char i:number){
            if(char_find(horizontal,i) == -1){
                horizontal_gap.append(i);}}
        char[] horizontal_gap_arr = horizontal_gap.toString().toCharArray();


        StringBuilder vertical_gap = new StringBuilder();

        int y = locate%9;
        char[] vertical = new char[9];
        for(int i=0; i<9; i++ ){
            vertical[i] = one_arr[y + (i*9)];}
        for(char i:number){
            if(char_find(vertical,i) == -1){
                vertical_gap.append(i);}}
        char[] vertical_gap_arr = vertical_gap.toString().toCharArray();


        int x_nine, y_nine;
        x_nine = ((x/9) - ((x/9)%3))/3;
        y_nine = (y - y%3)/3;
        int loc =  x_nine*27 + y_nine*3;
        char[] nine_nine = new char[9];
        for(int i=0; i<3; i++){
            nine_nine[i*3] = one_arr[loc + 9*i];
            nine_nine[i*3 + 1] = one_arr[loc + 1 + 9*i];
            nine_nine[i*3 + 2] = one_arr[loc + 2 + 9*i];
        }
        StringBuilder nine_nine_gap = new StringBuilder();
        for(char i:number){
            if(char_find(nine_nine, i) == -1){nine_nine_gap.append(i);}}
        char[] nine_nine_gap_arr = nine_nine_gap.toString().toCharArray();


        StringBuilder total_gap = new StringBuilder();
        for(char i:number){
            if(char_find(horizontal_gap_arr, i) != -1 && char_find(vertical_gap_arr, i) != -1 && char_find(nine_nine_gap_arr, i) != -1){
                total_gap.append(i);}}
        char[] total_gap_arr = total_gap.toString().toCharArray();

        return total_gap_arr;

    }


}

