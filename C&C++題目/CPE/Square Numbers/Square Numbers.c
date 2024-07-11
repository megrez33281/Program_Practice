#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    int a,b;
    int hash[100001] = {0};
    while(scanf("%d%d",&a,&b) != EOF){
        if(a==0 && b==0){break;}
        int total = 0;

        for(int i=a; i<=b; i++){
            if(hash[i] == 1){
                total++;
            }
            else if(hash[i] == 0){
                if((float)pow(i,0.5) == (int)pow(i,0.5)){
                    total++;
                    hash[i] = 1;
                }
                else{
                    hash[i] = -1;
                }
            }
        }
        printf("%d\n",total);
    }

    return 0;
}
