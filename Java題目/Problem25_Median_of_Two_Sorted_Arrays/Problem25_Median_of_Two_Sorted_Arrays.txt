/**
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

 The overall run time complexity should be O(log (m+n)).
 */
package Problem25_Median_of_Two_Sorted_Arrays;
import java.lang.String;
import java.util.Scanner;


public class Problem25_Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String num1_str = input.nextLine();
        String num2_str = input.nextLine();
        double[] num1 = StringToDouble(num1_str);
        double[] num2 = StringToDouble(num2_str);

        double[] num = sortList(num1,num2);
        if(num.length % 2 == 0){
            //System.out.println("even");
            double number1 = num[num.length/2];//0,1,2,3   4/2 = 2
            double number2 = num[(num.length/2)-1];
            double answer = (double)(number1 + number2)/2;
            System.out.println(answer);
        }

        else{
            double number = num[(num.length-1)/2]; //3, 0.1.2 (3-1)/2
            System.out.println(number);
        }


        //for(double i:num){System.out.print(i + " ");} //遍歷

    }

    public static double[] sortList(double[] num1, double[] num2){

        double[] answer = Combine(num1,num2);

        return SignalSort(answer);



    }

    public static double[] SignalSort(double[] num){

        while(!ifSorted(num)){
            for(int i =0; i<num.length-1; i++){
                if(num[i] > num[i+1]){
                    double temp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = temp;
                }
            }
        }

        return num;

    }

    public static boolean ifSorted(double[] num){

        for(int i=0; i<num.length-1; i++){
            if(num[i] > num[i+1]){return false;}
        }

        return true;

    }

    public static double[] Combine(double[] num1, double[] num2){

        int length = num1.length + num2.length;
        double[] num = new double[length];
        int count = 0;
        for(double i: num1){num[count] = i;
            count++;}
        for(double j: num2){num[count] = j;
            count++;}

        return num;
    }

    public static double[] StringToDouble(String num){

        String[] list = num.split(" ");
        double[] answer = new double[count(num)];
        for(int i=0,j=0; i<list.length; i++){
            if(isNumber(list[i])){answer[j] = Double.parseDouble(list[i]);j++;}
        }

        return answer;

    }

    public static int count(String string){
        String[] list = string.split(" ");
        int count = 0;
        for(String i :list){
            if(isNumber(i)){count++;}

        }
        return  count;
    }

    public static boolean isNumber(String string){
        char[] list = string.toCharArray();
        for(char i : list){
            if((i < '0' || i >'9' ) && i != '.'){
                return false;
            }
        }
        return true;
    }

}
