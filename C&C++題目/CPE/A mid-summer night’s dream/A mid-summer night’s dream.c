#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>

int main(){
	int N;
	while(scanf("%d",&N) != EOF){
		int* arrays = (int*)calloc(N, sizeof(int));
		for(int i=0; i<N; i++){
			scanf("%d",&arrays[i]);
		}
		//bubble sort
		bool sorted=false;
		for(int i=N-1; i>=0 && !sorted; i--){
			sorted = true;
			for(int j=1; j<=i; j++){
				if(arrays[j] < arrays[j-1]){
					int temp = arrays[j];
					arrays[j] = arrays[j-1];
					arrays[j-1] = temp;
					sorted = false;
				}			
			}
		}
		int middle = (N%2 == 0)?(arrays[N/2 -1]):(arrays[N/2]);
		printf("%d ",middle);
		int total = 0;
		int middleII = -1;
		if(N%2 == 0){
			middleII = arrays[N/2];  //another middle value when N is even
		}
		for(int i=0; i<N; i++){
			if(arrays[i] == middle || arrays[i] == middleII){
				total++;
			}
		}

		printf("%d ",total);
		if(N%2 == 1){
			printf("%d",1);
		}
		else{
			printf("%d",middleII-middle+1);
		}
		printf("\n");
		
		free(arrays);
	}


	return 0;
}