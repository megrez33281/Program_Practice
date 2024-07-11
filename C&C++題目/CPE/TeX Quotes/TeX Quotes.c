#include <stdio.h>
#include <string.h>
#include <stdbool.h>



int main(void) {
    char word = 0;
    bool flag = true;
    while( (word = getchar()) != EOF){
        if(word == '"'){
            (flag)?printf("``"):printf("''");
            flag = !flag;
            }
        else{
            printf("%c",word);
            }
    }
    return 0;
}
