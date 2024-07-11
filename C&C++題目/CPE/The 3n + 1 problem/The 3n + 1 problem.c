#include <stdio.h>


int cycleLength(int num){

    int length = 1;
    while(num != 1){
        if(num%2 ==1){
            num = num*3 +1;
        }
        else{
            num/=2;
        }
        length++;
    }
    return length;
}

int main(void) {

    int* hash = (int*)calloc(1000000,sizeof(int));//申請動態空間並初始化為0
    int wallI=0,wallII=0;
    while(scanf("%d %d",&wallI,&wallII) != EOF){
        printf("%d %d ",wallI,wallII);
        if(wallI > wallII){//確保wallI為較小
            int temp = wallI;
            wallI = wallII;
            wallII = temp;
        }
        int max = 0;

        for(;wallI <= wallII; wallI++){
            if(hash[wallI] == 0){
                hash[wallI] = cycleLength(wallI);
            }//加入哈希表
            if(hash[wallI] > max){
                max = hash[wallI];
            }
        }
        printf("%d\n",max);
    }
    free(hash);



    return 0;
}
