#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    int a,b;
    int hash[100001] = {0};
    while(scanf("%d%d",&a,&b) != EOF){
        if(a==0 && b==0){break;}
        int start = ceil(pow(a,0.5));
        int end = floor(pow(b,0.5));
        printf("%d\n",end-start+1);
    }

    return 0;
}
