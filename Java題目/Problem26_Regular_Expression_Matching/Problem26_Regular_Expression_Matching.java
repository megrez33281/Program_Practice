/**
 Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).
 ex:
 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 */

package Problem26_Regular_Expression_Matching;
import java.lang.String;
import java.util.Scanner;


public class Problem26_Regular_Expression_Matching {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String p = input.nextLine();
        Match match = new Match();
        System.out.println(match.isMatch(s,p));

    }


}


class Match{

    public boolean isMatch(String s, String p){

        if(p.isEmpty()){return s.isEmpty();}//p為空且s為空
        //若s為空p不為空不一定是false，但若p為空，s不為一定是false
        //已知p不為空，若s為空first_char即為false
        boolean first_char = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));//出口

        if (p.length() >= 2 && p.charAt(1) == '*') {

            return (isMatch(s,p.substring(2)) || (first_char && isMatch(s.substring(1),p)));

        }

        else{

            return (first_char && isMatch(s.substring(1),p.substring(1)));
        }



    }
    /*此函示為判斷pattern 和 s 是否相等(符合題目定義)
    * 從字串頭部分析
    * 若pattern長度大於等於2且其第1位元等於'*'
    * 只要pattern從第二位元開始的子字串等於s 或 pattern等於s從第1位元開始的字串即代表pattern字串等於s字串
    *
    * 當pattern小於2 或 其第1位元不等於'*
    * 需要pattern的第0位元等於s的零位元 且 pattern從1開始的字元等於s從1開始的字元
    *
    * */



}


