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
    else if(b[i] == 0 && a[i] == 0){return 2;}//�۵�
    return 0;

}

int main(void) {

    //Ū���H��
    int sum;
    scanf("%d",&sum);
    char country[2001][76]; //�ΥH�s����W
    char names[76];
    int i=0;
    for(; i<sum; i++){
        scanf("%s",&country[i]); //�N��W�s�Jcountry���Ascanf���S�ʬ�Ū����Ů氱��
        gets(&names);   //gets���S�ʬ�Ū���촫���䰱��A�i�Ω�L�o�H�W
    }

    //����country���s�J�Ҧ��H����a
    //�i��bubble sort
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

    //����country�����g�L�ƧǪ���a
    int total = 0;
    for(int j=0; j<i; j++){
        if(j == 0){
            printf("%s ",country[0]);
            total++;
            continue;}
        if(Isbigger(country[j],country[j-1]) == 2){//�ۦP��a
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
