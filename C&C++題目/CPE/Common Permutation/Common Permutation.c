#include <stdio.h>


int main(void) {

    char listI[1001] = {};
    char listII[1001] = {};

    while(scanf("%s",listI) && scanf("%s",listII)){
        //�إߦr����ΥH�����C�զr��ӭӳ�r�X�{������
        //����listI�BlistII�����r��
        int letterI[26] = {0};
        int letterII[26] = {0};
        int pointer = 0;
        int lenListI = strlen(listI);
        int lenListII = strlen(listII);
        while(pointer < lenListI || pointer < lenListII){

            if(pointer < lenListI){
                int index = listI[pointer]-'a'; //�o��n�s�J����m
                letterI[index]++;//�����X�{���r��
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
