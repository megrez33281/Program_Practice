#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {
    int T;
    scanf("%d",&T);
    while(T--){
        int s,d; //s:分數和  d:分數差
        scanf("%d %d",&s,&d);
        if(d > s){
            printf("impossible\n");
        }
        else{
            float a = (float)(s+d)/2;
            float b = (float)(s-d)/2;
            if((float)a != (int)a || (float)b != (int)b){
                printf("impossible\n");
            }
            else{
                if(a > b){
                    printf("%d %d\n",(int)a,(int)b);
                }
                else{
                    printf("%d %d\n",(int)b,(int)a);
                }

            }
        }

    }

    return 0;
}
