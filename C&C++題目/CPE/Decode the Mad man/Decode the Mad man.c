#include <stdio.h>



int main(void) {

    char words[1000]={};

    //�ت�
    char from[] = {" 234567890-=ertyuiop[]\\dfghjkl;'cvbnm,./"};
    char to[] = {" `1234567890qwertyuiop[asdfghjklzxcvbnm,"};


    while(gets(words)){ //���o��J

        for(int i=0; i<strlen(words); i++){
            for(int j=0; j<strlen(from); j++){
                if(from[j] == words[i]){
                    printf("%c",to[j]);
                }
            }


        }

        printf("\n");
    }

    return 0;
}
