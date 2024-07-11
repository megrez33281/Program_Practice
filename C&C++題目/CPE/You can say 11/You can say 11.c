#include <stdio.h>



int main(void) {

    char* words = (char*) calloc(1001,sizeof(char));

    while(scanf("%s",words) != EOF){
        if(words[0] == '0'&& words[1] == 0){
                break;
        }
        printf("%s ",words);
        //盢计籔案计
        //璝ㄢ搭ぇ荡癸11ぇ计玥赣11ぇ计はぇぃ琌
        int bucketI = 0;
        int bucketII = 0;//眖オぃ笵计
        int i = 0; //皐
        while(words[i] != 0){

            bucketI += (words[i]-'0');
            i++;
            if(words[i] != 0){
                bucketII += (words[i]-'0');
                i++;
            }
            else{
                break;
            }

        }
        int sub = bucketI - bucketII;
        if(sub < 0){sub *= -1;}
        if(sub % 11 == 0){
            printf("is a multiple of 11.\n");
        }
        else{
            printf("is not a multiple of 11.\n");
        }

    }

    return 0;
}
