/**
月曆查詢
 */
package com.company;
import java.util.Scanner;
import java.lang.String;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("請輸入西元年：");
        int year = input.nextInt();
        System.out.print("請輸入月份：");
        int month = input.nextInt();
        String[] day = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        String[] month_str = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
        System.out.printf("%15s",month_str[month-1] +'\n');
        System.out.println("===========================");//27
        for(String i : day){System.out.print(i + " ");}
        System.out.print("\n");

        int date_one_week = week_day(year,month);
        int date = date(year,month);
        for(int i=0; i< 1 + (date_one_week)*4; i++){
            System.out.print(" ");}

        for(int i=1, j = date_one_week; i <= date; i++,j++){
            if(j % 7 == 0 && i<10 && i > 1)
                {System.out.print("\n " + i);}
            else if(j % 7 == 0 && i > 1)
                {System.out.print("\n" + i);}
            else if( i == 1)
                {System.out.print(i);}
            else if(i >= 10)
                {System.out.print("  " + i);}
            else
                {System.out.print("   " + i);}
        }

    }

    private static int week_day(int year, int month){

        int year_hundred = (year-(year%100))/100;
        int year_byte = (year%100);
        int[] century_code = {0, 5, 3, 1};
        int[] month_code = {6,2,2,5,0,3,5,1,4,6,2,4};
        int four_years_time = (year_byte - (year_byte%4))/4;
        int week_day;

        if((month == 1 || month == 2) && (leap_year(year))){
            week_day = (month_code[month-1] + year_byte + four_years_time + century_code[year_hundred%4])%7;
        }

        else
            {week_day = (1 + month_code[month-1] + year_byte + four_years_time + century_code[year_hundred%4])%7;}

        return week_day;
        }



    private static boolean leap_year(int year){

        if(year % 4 != 0 ){
            return false;
        }

        else if(year % 100 != 0){
            return true;
        }

        else if(year % 100 == 0 && year % 400 !=0){
            return false;
        }

        else{
            return true;
        }

    }

    private static int date(int year, int month){

        if(month == 2 && leap_year(year))
            {return 29;}

        else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            {return 31;}

        else if(month == 2)
            {return 28;}

        else
            {return 30;}
    }
}



