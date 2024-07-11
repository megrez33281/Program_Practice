#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int main(){

	int N;
	while(scanf("%d",&N) != EOF){
		if(N == 0){break;}
		printf("The parity of ");
		int parity = 0;
		int binary[32] = {0};
		int index = 0;
		while(N > 0){
			if(N %2 == 1){
				binary[index++] = 1;
				parity++;
			}
			else{
				binary[index++] = 0;
			}
			N /= 2;
		}
		for(int i=index-1; i>=0; i--){
			printf("%d",binary[i]);
		}


		printf(" is %d (mod 2).\n",parity);
	}



	return 0;
}
