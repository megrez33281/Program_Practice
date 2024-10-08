#include <stdio.h>


int main(void) {

  int a,b;
  while(scanf("%d %d",&a,&b) != EOF){
    if(a==0 && b==0){break;}

    int carry = 0;
    int total = 0;
    while(a !=0 || b!=0){
         //檢查目前位數相加是否進位
        if(a%10 +b%10+carry >= 10){
            carry = 1;//若會進位則下一位數會有一個carry
            total ++; //進位的數量
        }
        else{
            carry = 0; //清除carry
        }
        a /= 10;
        b /= 10;
    }
    printf("a:%d b:%d\n",a,b);
    if(a+b+carry >= 10){total++;}//檢查最高位的進位
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
