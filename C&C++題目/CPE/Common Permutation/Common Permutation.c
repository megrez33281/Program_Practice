#include <stdio.h>


int main(void) {

    char listI[1001] = {};
    char listII[1001] = {};

    while(scanf("%s",listI) && scanf("%s",listII)){
        //建立字母表用以紀錄每組字串個個單字出現的紀錄
        //紀錄listI、listII中的字母
        int letterI[26] = {0};
        int letterII[26] = {0};
        int pointer = 0;
        int lenListI = strlen(listI);
        int lenListII = strlen(listII);
        while(pointer < lenListI || pointer < lenListII){

            if(pointer < lenListI){
                int index = listI[pointer]-'a'; //得到要存入的位置
                letterI[index]++;//紀錄出現的字母
            }

            if(pointer < lenListII){
                int index = listII[pointer] - 'a';
                letterII[index]++;
            }

            pointer++;
        }


        for(int i=0; i<26; i++){
            if(letterI[i] > 0 && letterII[i] > 0){
                int sum = (letterI[i] > letterII[i])?letterII[i]:letterI[i];
                for(int j=0; j<sum;j++){
                    printf("%c", 'a'+i);
                }
            }
        }
        printf("\n");



    }


    return 0;
}
