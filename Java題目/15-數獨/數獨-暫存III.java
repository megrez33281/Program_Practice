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

       String sudo_str = read("sudo");//數獨的檔案名稱
       char[] sudo_one_arr = str_to_char(sudo_str);
       write("answer",""); // 檔案用來判定是否結束函式find_answer
       find_answer(sudo_one_arr);

    }


    private static void find_answer(char[] sudo_one_arr){

        int[] empty_arr = find_empty(sudo_one_arr);
        int sum_of_empty = empty_arr.length;
        char[][] possible_two_arr = new char[sum_of_empty][9];
        int possible_answer_sum = 0;
        int leastI =  least_possible_number(sudo_one_arr);
        String sudo_str_read = read("answer");

        if(sudo_str_read.length() < 80) {
            while (leastI == 1) {
                int least_locate = find_the_least_locate(sudo_one_arr, leastI);
                char[] list = judge(sudo_one_arr, least_locate);
                sudo_one_arr[least_locate] = list[0];
                leastI = least_possible_number(sudo_one_arr);
            }

            int emptyI = find_empty(sudo_one_arr).length;

            if (emptyI != 0) {
                for (int i = 0; i < sum_of_empty; i++) {
                    possible_two_arr[i] = judge(sudo_one_arr, empty_arr[i]);
                    possible_answer_sum += possible_two_arr[i].length;
                }


                char[][] possible_answer = new char[possible_answer_sum][81];
                for (int i = 0; i < possible_answer_sum; i++) {
                    System.arraycopy(sudo_one_arr, 0, possible_answer[i], 0, 81);
                }

                int l = 0;
                for (int i = 0; i < sum_of_empty; i++) {
                    for (int j = 0; j < possible_two_arr[i].length; j++) {
                        possible_answer[l][empty_arr[i]] = possible_two_arr[i][j];
                        l++;
                    }
                }

                for (int i = 0; i < possible_answer_sum; i++) {

                    int least = least_possible_number(possible_answer[i]);
                    int empty = find_empty(possible_answer[i]).length;
                    if (least != 0 && empty != 0) {
                        find_answer(possible_answer[i]);
                    }
                }
            } else if (judge_answer(sudo_one_arr)) {
                print_the_sudo(sudo_one_arr);
                String sudo_str = sudo_str(sudo_one_arr);
                write("answer", sudo_str);
            }


        }
    }

    private static int char_find(char[] char_list, char search){

        for(int i=0; i<char_list.length; i++){

            if(char_list[i] == search){
                return i;}}

        return -1;

    }

    private static boolean if_content_one_to_nine(char[] char_list){

        char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(char i:number){
            if(char_find(char_list,i) == -1){return false;}
        }

        return true;
    }

    private static int[] find_empty(char[] char_list){

        int empty_sum = 0;
        for(int i=0; i<char_list.length; i++){
            if(char_list[i] == ' '){
                empty_sum++;}}

        int[] empty_arr = new int[empty_sum];
        for(int i=0,j=0; i<char_list.length; i++){

            if(char_list[i] == ' '){
                empty_arr[j] = i;
                j++;}}

        return empty_arr;


    }

    private static boolean judge_answer(char[] sudo_list){

        for(int i=0; i<9; i++){
            char[] number_list = new char[9];
            for(int j=0; j<9; j++){
                number_list[j] = sudo_list[9*i + j];}
            if(!if_content_one_to_nine(number_list)){return false;}}

        for(int i=0; i<9; i++){
            char[] number_list = new char[9];
            for(int j=0; j<9; j++){
                number_list[j] = sudo_list[i + j*9];}
            if(!if_content_one_to_nine(number_list)){return false;}}

        int[] list = {0, 3, 6, 27, 30, 33, 54, 57, 60};
        for(int i=0; i<9; i++){
            char[] number_list = new char[9];
            for(int j=0; j<3; j++){
                number_list[j*3] = sudo_list[list[i] + j*9];
                number_list[j*3 +1] = sudo_list[list[i] + j*9 + 1];
                number_list[j*3 +2] = sudo_list[list[i] + j*9 + 2];}
            if(!if_content_one_to_nine(number_list)){return false;}}

        return true;

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

    private static void print_the_sudo(char[] char_list){
        for(int i=0; i<81; i++){
            System.out.print(char_list[i]);
            if(i%9 == 8){System.out.print("\n");}
        }

    }

    private static int find_the_least_locate(char[] char_list, int least){

        for(int i=0; i<81; i++){
            if(char_list[i] == ' '){
                char[] possible_list = judge(char_list,i);
                if(possible_list.length == least){
                    return i;}}}
        return -1;

    }

    private static int least_possible_number(char[] char_list){

        int least = 100;
        for(int j=0; j<81; j++){
            if(char_list[j] == ' '){
                char[] list = judge(char_list,j);
                if(list.length < least){least = list.length;}}}

        return least;
    }

    private static String sudo_str(char[] sudo_one_arr){

        StringBuilder sudo_str = new StringBuilder();
        for(int i=0; i<81; i++){

            sudo_str.append(sudo_one_arr[i]);
            if(i%9 == 8){sudo_str.append('\n');}}

        return sudo_str.toString();
    }


}

