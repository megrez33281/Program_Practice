//使用Java的考生請注意，最外層的類別(class)需命名為 main 。
//如果遇到超乎想像的狀況，請更改編譯器試看看!! 各編譯器特性不同!!
//預設測資、隨機測資、固定測資是用來幫助除錯用的。批改時，只看暗中測資是否通過!!

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
// 0 0 0 0 0 0 0  0 0 0   0  0 0  0  0  0  0       
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int judge(int N, int m){
	
	int* hash = (int*)calloc(N,sizeof(int));
	hash[0] = 1;
	int count = 1;
	int amount = 0;
	int index = 0;
	int judge = 1;
	while(count < N && judge){
	    //find target
		while(amount < m && judge){
			amount++;
			index++;
			index %= N;
			while(hash[index] == 1){
				index++;
				index %= N;
			}
		}
		amount = 0;
		hash[index] = 1;
		//printf("%d ",index+1);
		count++;
		if(index == 12 && count != N){
			judge = 0;
			break;
		}	
	
	}
	
	if(judge){
		return 1;
	}
	else{
		return 0;
	}
	


	free(hash);
}


int main(){

	int N;
	while(scanf("%d",&N) != EOF){
		if(N == 0){break;}
		for(int i=1; i<999; i++){
			if(judge(N,i)){
				printf("%d\n",i);
				break;
			}
	
		}
	
	
	}


	return 0;
}