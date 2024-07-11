#include <stdio.h>

void Change(long long int number){

    if(number >= 10000000){
        Change(number / 10000000);//��Xkuti���ƶq�A�Y�O�j��100�A�|�~�����
        printf("kuti ");//��X����
        number %= 10000000;//��X��p�����ؼƶq
    }
    if(number >= 100000){
        Change(number/100000);//��Xlakh���ƶq
        printf("lakh ");//��X����
        number %= 100000;//��X��p�����ؼƶq
    }
    if(number >= 1000){
        Change(number/1000);//��Xhajar���ƶq
        printf("hajar ");//��X����
        number %= 1000;//��X��p�����ؼƶq
    }
    if(number >= 100){
        Change(number/100);//��Xshata���ƶq
        printf("shata ");//��X����
        number %= 100;//�o�X���ؼƶq
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
            Change(number); //�ư��̫���
        }
        else{
            printf("0");
        }
        printf("\n");

    }

    return 0;
}
