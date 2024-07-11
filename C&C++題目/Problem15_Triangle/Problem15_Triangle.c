#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define max(a,b) (a>b)?a:b
#define min(a,b) (a>b)?b:a


//可以將此三角形視為一個tree，每個node都有左子樹(題目中的i)和右子數(題目中的i+1)
int minimumTotal(int** triangle, int triangleSize, int* triangleColSize){

    if(triangleSize == 1){
        return triangle[0][0];
    }
    //利用動態規劃由下往上，每次將當前層的下面一層的左、右兩個數字中最小者加上當前數字
    for(int level=triangleSize-2; level>=0; level--){
        for(int node = 0; node<triangleColSize[level]; node++){
            triangle[level][node] += min(triangle[level+1][node], triangle[level+1][node+1]);
        }
    }

    return triangle[0][0];
}
int main() {
    int triangleSize = 3;
    int** triangle = (int**)malloc(sizeof(int*)*triangleSize);
    int* triangleColSize = (int*)malloc(sizeof(int)*triangleSize);
    int numbers[6] = {-1,2,3,1,-1,-3};
    int index = 0;
    for(int i=0; i<triangleSize; i++){
        triangleColSize[i] = i+1;
        triangle[i] = (int*)malloc(sizeof(int)*triangleColSize[i]);
    }
    for(int i=0; i<triangleSize; i++){
        for(int j=0; j<triangleColSize[i]; j++){
            triangle[i][j] = numbers[index++];
        }
    }
    for(int i=0; i<triangleSize; i++){
        for(int j=0; j<triangleColSize[i]; j++){
            printf("%d ", triangle[i][j]);
        }
        printf("\n");
    }
    int sum = minimumTotal(triangle,triangleSize,triangleColSize);
    printf("%d\n", sum);
    free(triangle);
    free(triangleColSize);
    return 0;
}
