#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int main(void) {

    int time;
    scanf("%d",&time);
    for(int k=0; k<time; k++){
        int n,i;
        double p;
        scanf("%d%lf%d",&n,&p,&i);
        //q = 1-p
        //首項為(1-p)^(i-1) => pow(1-p,i-1)
        //公比為(1-p)^n => pow(1-p,n)
        //利用等比級數求解到無限回合：S = p*a/(1-((1-p)^n))
        printf("%.4f\n", (double)p*pow(1-p,i-1)/(1-pow(1-p,n)));


    }


    return 0;
}
