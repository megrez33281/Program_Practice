#include <stdio.h>



int main(void) {

    char* words = (char*) calloc(1001,sizeof(char));

    while(scanf("%s",words) != EOF){
        if(words[0] == '0'&& words[1] == 0){
                break;
        }
        printf("%s ",words);
        //�N�_�Ʀ�P���Ʀ�U�۬ۥ[
        //�Y�ۥ[���̬۴����Ȭ�11�����ơA�h�ӭȬ�11�����ơA�Ϥ����O
        int bucketI = 0;
        int bucketII = 0;//�q����k�A�����D�Ʀr����
        int i = 0; //���w
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
