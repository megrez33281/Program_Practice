#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){

	int m,n;
	int Case = 1;
	bool flag = false;
	while(scanf("%d %d ",&m,&n)){
		if(m == 0 && n==0){
			printf("\n");
			break;}
		if(flag){printf("\n\n");}
		else{
			flag = true;
		}	
		printf("Field #%d:\n",Case++);
		char arrays[101][101]={};
		int sum[101][101]={0};
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				scanf("%c",&arrays[i][j]);
				if(arrays[i][j] == '*'){
					if(i-1 >= 0 && j-1 >= 0){
						sum[i-1][j-1]++;}
					if(i-1>=0){
						sum[i-1][j]++;}
					if(i-1 >=0 && j+1 <n){
						sum[i-1][j+1]++;}
					if(j-1 >=0){
						sum[i][j-1]++;}
					if(j+1 < n){
						sum[i][j+1]++;}
					if(i+1 < m && j-1 >=0){
						sum[i+1][j-1]++;}
					if(i+1 < m ){
						sum[i+1][j]++;}
					if(i+1 < m && j+1 < n){
						sum[i+1][j+1]++;}
				}
			}
			getchar();
		}
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(arrays[i][j] == '*'){
					printf("%c",arrays[i][j]);
				}
				else{
					printf("%d",sum[i][j]);
				}
				
			}
			if(i != m-1){
				printf("\n");}
		}
	
	
	
	}


	return 0;
}