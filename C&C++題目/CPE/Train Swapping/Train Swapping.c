#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>


int main(){

	int Case;
	scanf("%d",&Case);
	while(Case--){
		int sum;
		scanf("%d",&sum);
		int* arrays = (int*)calloc(sum,sizeof(int));
		for(int i=0; i<sum; i++){
			scanf("%d",&arrays[i]);
		}
		
		int total = 0;
		for(int i=sum-1; i>=0; i--){
			for(int j=1; j<=i; j++){
				if(arrays[j] < arrays[j-1]){
					total++;
					int temp = arrays[j];
					arrays[j] = arrays[j-1];
					arrays[j-1] = temp;
				}
			}
		}
		printf("Optimal train swapping takes %d swaps.\n",total);
	
	
	
	
	
	}

	return 0;
}