#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>


int main(){
	
	
	int N,m;
	while(scanf("%d %d",&N,&m) != EOF){
		if(N == 0 && m == 0){break;}
		int* arrays = (int*)calloc(N,sizeof(int));
		for(int i=0; i<N; i++){
			scanf("%d",&arrays[i]);
		}
		printf("%d %d\n",N,m);
		//bubble sort
		bool sorted = false;
		for(int i=N-1; i>=0 && sorted == false; i--){
			sorted = true;
			for(int j=1; j<=i; j++){
				if(arrays[j]%m < arrays[j-1]%m || (arrays[j]%m == arrays[j-1]%m && ((abs(arrays[j]%2) == 1 && arrays[j-1]%2 == 0) || (abs(arrays[j]%2) == 1 &&  abs(arrays[j-1]%2) == 1 && arrays[j] > arrays[j-1] ) || (arrays[j]%2 == 0  && arrays[j-1]%2 == 0 && arrays[j] < arrays[j-1]))) ){
					int temp = arrays[j];
					arrays[j] = arrays[j-1];
					arrays[j-1] = temp;
					sorted = false;
				}
			
			
			}
		
		}
		
		for(int i=0; i<N; i++){
			printf("%d\n",arrays[i]);
		}
		printf("0 0\n");
	
		free(arrays);
	}


	return 0;
}