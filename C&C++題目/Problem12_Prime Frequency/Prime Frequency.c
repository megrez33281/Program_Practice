#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int isPrime(int n){
    if(n<=1){
        return 0;
    }
    else if(pow(n,0.5) < 2){
        return 1;
    }
    for(int i=2; i<= pow(n,0.5); i++){
        if(n%i == 0){
            return 0;
        }
    }
    return 1;

}


int main(void) {
    int lines;
    scanf("%d",&lines);
    getchar();
    int index = 1;
    while(lines--){
        int hash[62] = {0}; //0~9 -> 0~9，A~Z -> 10~35，a~z -> 36~61
        char words[2001]={};
        gets(words);
        for(int i=0; i<strlen(words); i++){
            if('0' <= words[i] && words[i] <= '9'){
                hash[words[i]-'0']++;
            }
            else if('A' <= words[i] && words[i] <= 'Z'){
                hash[words[i]-'A' + 10]++;
            }
            else if('a' <= words[i] && words[i] <= 'z'){
                hash[words[i]-'a' + 36]++;
            }
        }
        printf("Case %d: ",index);
        index++;
        bool flag = false;
        for(int i=0; i<62; i++){
            if(isPrime(hash[i])){
                flag = true;
                if(0 <= i && i <= 9){
                    printf("%c", i+'0');
                }
                else if(10 <= i && i <= 35){
                    printf("%c", i+'A'-10);
                }
                else if(i >= 36){
                    printf("%c", i + 'a' - 36);
                }
            }
        }
        if(!flag){
            printf("empty");
        }
        printf("\n");

    }

    return 0;
}
