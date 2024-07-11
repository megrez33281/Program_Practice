#include <stdio.h>


int Isbigger(char* a, char* b){
    int i=0;
    for(; i<76 && a[i] != 0 && b[i] != 0; i++){
        if(a[i] < b[i]){
            return 0;
        }
        if(a[i] > b[i]){
            return 1;
        }
    }
    if(b[i] == 0 && a[i] != 0){return 1;}
    else if(b[i] == 0 && a[i] == 0){return 2;}//相等
    return 0;

}

int main(void) {

    //讀取人數
    int sum;
    scanf("%d",&sum);
    char country[2001][76]; //用以存取國名
    char names[76];
    int i=0;
    for(; i<sum; i++){
        scanf("%s",&country[i]); //將國名存入country中，scanf的特性為讀取到空格停止
        gets(&names);   //gets的特性為讀取到換行鍵停止，可用於過濾人名
    }

    //此時country中存入所有人的國家
    //進行bubble sort
    for(int j=i-1; j>=1; j--){
        for(int k=0; k<j; k++){
            if(Isbigger(country[k],country[k+1]) == 1){
                char temp[76];
                for(int l=0; l<76; l++){
                    temp[l] = country[k][l];
                }
                for(int l=0; l<76; l++){
                    country[k][l] = country[k+1][l];
                }
                for(int l=0; l<76; l++){
                    country[k+1][l] = temp[l];
                }

            }
        }
    }

    //此時country中為經過排序的國家
    int total = 0;
    for(int j=0; j<i; j++){
        if(j == 0){
            printf("%s ",country[0]);
            total++;
            continue;}
        if(Isbigger(country[j],country[j-1]) == 2){//相同國家
            total++;}
        else{
            printf("%d\n",total);
            printf("%s ",country[j]);
            total = 1;
        }
    }
    printf("%d\n",total);

    return 0;
}
