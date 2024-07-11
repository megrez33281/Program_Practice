#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {
    int T;
    scanf("%d",&T);
    int c=1;
    while(T--){
        int a,b;
        scanf("%d %d",&a,&b);
        int sum = 0;
        for(int j=a; j<=b; j++){
            if(j%2 ==1){sum+=j;}
        }
        printf("Case %d: %d\n",c++,sum);

    }


    return 0;
}
