#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {

    int Tcase = 1;
    int N;
    while(scanf("%d",&N) != EOF){
        int hash[20002] = {0};
        int* array = (int*)calloc(N,sizeof(int));
        bool flag=true;
        for(int i=0; i<N; i++){
            scanf("%d",&array[i]);
        }
        for(int bi=0; bi<N; bi++){
            if(array[bi] < 0){
                flag = false;
                break;
            }
            else if(bi< N-1 && array[bi]>array[bi+1]);
            for(int bj=bi; bj<N; bj++){
                int index = array[bi]+array[bj];
                //printf("sum=%d ",index);
                if(hash[index] == 1){
                    flag = false;
                    break;
                }
                else{
                    hash[index] = 1;
                }
            }
        }
        if(flag){
            printf("Case #%d: It is a B2-Sequence.\n",Tcase++);
        }
        else{
            printf("Case #%d: It is not a B2-Sequence.\n",Tcase++);
        }
        free(array);
    }

    return 0;
}
