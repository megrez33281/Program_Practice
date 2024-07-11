#include <stdio.h>

int f(int n){

    int digitsum = 0;
    while(n != 0){
        digitsum += n%10;
        n/=10;
    }

    if(digitsum < 10){
        return digitsum;
    }
    else{
        return f(digitsum);
    }



}

int main(void) {

    int n=-1;
    while(n != 0){
        scanf("%d",&n);
        if(n != 0){
            printf("%d\n",f(n));}


    }


    return 0;
}
