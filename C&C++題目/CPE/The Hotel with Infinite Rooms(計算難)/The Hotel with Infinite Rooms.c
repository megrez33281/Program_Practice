#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    long long int date;
    int sum;
    while(scanf("%d %lld",&sum, &date) != EOF){

        int sumday = sum;
        while(sumday < date){
            sum++;
            sumday += sum;
        }
        printf("%d\n",sum);


    }
    return 0;
}
