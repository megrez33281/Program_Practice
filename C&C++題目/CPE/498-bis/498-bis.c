#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    int x;
    while(scanf("%d ",&x) != EOF){//加空格去掉換行鍵
        int coefficients[999] = {0};
        char bin;
        int index = 0;
        while(scanf("%d",&coefficients[index++]) != EOF){
            bin = getchar();
            if(bin == '\n'){
                break;
            }
        }
        int coefficient = index-1;
        long long int sum=0;
        for(int i=0; i<index-1; i++){
            sum += coefficient*pow(x,--coefficient)*coefficients[i];
        }
        printf("%lld\n",sum);

    }


    return 0;
}
