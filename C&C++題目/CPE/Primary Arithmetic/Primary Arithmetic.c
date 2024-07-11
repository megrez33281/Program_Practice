#include <stdio.h>


int main(void) {

  int a,b;
  while(scanf("%d %d",&a,&b) != EOF){
    if(a==0 && b==0){break;}

    int carry = 0;
    int total = 0;
    while(a !=0 || b!=0){
         //浪琩ヘ玡计琌秈
        if(a%10 +b%10+carry >= 10){
            carry = 1;//璝穦秈玥计穦Τcarry
            total ++; //秈计秖
        }
        else{
            carry = 0; //睲埃carry
        }
        a /= 10;
        b /= 10;
    }
    printf("a:%d b:%d\n",a,b);
    if(a+b+carry >= 10){total++;}//浪琩程蔼秈
    if(total == 0){
        printf("No carry operation.\n");
    }
    else if(total == 1){
        printf("1 carry operation.\n");
    }
    else{
        printf("%d carry operations.\n",total);
    }

  }



  return 0;
}
