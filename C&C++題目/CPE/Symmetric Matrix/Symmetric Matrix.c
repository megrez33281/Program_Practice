#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    int T;
    int Tcase = 1;
    scanf("%d",&T);
    while(T--){
        int n;
        while(getchar()!='='){};
        scanf("%d",&n);
        long long int array[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = 0;
                scanf("%lld",&array[i][j]);
            }
        }
        bool symmetric = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if((array[i][j] < 0) || (array[i][j] != array[n-i-1][n-j-1])){
                    symmetric = false;
                    break;
                }
            }
        }
        if(symmetric){
            printf("Test #%lld: Symmetric.\n",Tcase++);
        }
        else{
            printf("Test #%lld: Non-symmetric.\n",Tcase++);
        }


    }

    return 0;
}
