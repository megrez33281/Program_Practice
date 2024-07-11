#include <stdio.h>

void Change(long long int number){

    if(number >= 10000000){
        Change(number / 10000000);//輸出kuti的數量，若是大於100，會繼續切割
        printf("kuti ");//輸出幣種
        number %= 10000000;//找出更小的幣種數量
    }
    if(number >= 100000){
        Change(number/100000);//輸出lakh的數量
        printf("lakh ");//輸出幣種
        number %= 100000;//找出更小的幣種數量
    }
    if(number >= 1000){
        Change(number/1000);//輸出hajar的數量
        printf("hajar ");//輸出幣種
        number %= 1000;//找出更小的幣種數量
    }
    if(number >= 100){
        Change(number/100);//輸出shata的數量
        printf("shata ");//輸出幣種
        number %= 100;//得出幣種數量
    }
    if(number > 0){
        printf("%d ",number);
    }




}

int main(void) {


    long long int number;
    int total = 1;
    while(scanf("%lld",&number) != EOF){
        printf("%d. ",total);
        total++;
        if(number != 0){
            Change(number); //排除最後兩位
        }
        else{
            printf("0");
        }
        printf("\n");

    }

    return 0;
}
