#include <stdio.h>

struct english{
    int sum;
    char character;

};

int main(void) {

    struct english vo[26];//存取字母
    for(int i=0; i<26; i++){
        vo[i].sum = 0;
        vo[i].character ='A'+i;
    }
    int row;
    scanf("%d",&row);
    for(int i=0; i<=row; i++){//因為有換行符號的原因，需多執行一次
        char words[1000] = {};
        gets(words);
        int index=0;
        while(words[index] != 0){
            if('a'<= words[index] && words[index] <= 'z'){
                int vo_index = words[index]-'a';
                vo[vo_index].sum++;
            }
            else if('A' <= words[index] && words[index] <= 'Z'){
                int vo_index = words[index] - 'A';
                vo[vo_index].sum++;
            }
            index++;
        }
    }

    //bubble sort
    for(int i=25; i>=1; i--){
        for(int j=0; j<i; j++){
            if(vo[j].sum < vo[j+1].sum){
                struct english temp = vo[j];
                vo[j] = vo[j+1];
                vo[j+1] = temp;
            }
        }
    }
    for(int i=0; i<26; i++){
        if(vo[i].sum > 0){
            printf("%c %d\n",vo[i].character,vo[i].sum);
        }
    }

    return 0;
}
