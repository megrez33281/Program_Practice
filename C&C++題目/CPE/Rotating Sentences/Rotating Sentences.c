#include <stdio.h>


int main(void) {

    char str[101][101];
    int index = 0;
    int max_len=0;
    //�x�s��J��r
    while(index < 101 && gets(str[index])){
        if(strlen(str[index]) > max_len){
            max_len = strlen(str[index]);
        }
        index++;
    }

    //��X
    for(int i=0; i<max_len; i++){
        for(int j=index-1; j>=0; j--){
            if(i < strlen(str[j])){
                printf("%c",str[j][i]);
            }

        }
        printf("\n");

    }

    return 0;
}
