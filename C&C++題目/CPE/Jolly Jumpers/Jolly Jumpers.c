#include <stdio.h>
#include <string.h>
#include <stdbool.h>



int main(void) {

    int n=0;
    int a; //接取數字
    while(scanf("%d",&n) != EOF){
        int hash[3001] = {0};
        scanf("%d",&a);
        bool jolly = true;
        for(int i=1; i<n; i++){
            int b;
            scanf("%d",&b);
            int sub = a - b;
            int dist = (sub <0)?sub*-1:sub;
            a = b;
            if(dist >= 1 && dist < n && hash[dist] == 0){
                hash[dist] = 1;
            }
            else{
                jolly = false;
            }
            }


        if(jolly){
            printf("Jolly\n");
        }
        else{
            printf("Not jolly\n");
        }

    }


    return 0;
}
