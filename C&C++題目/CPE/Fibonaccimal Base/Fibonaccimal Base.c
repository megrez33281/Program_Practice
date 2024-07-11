#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int main(){

	int T;
	scanf("%d",&T);

	while(T--){
		int fibonaccimal[1000]= {};
		int dec;
		scanf("%d",&dec);
		printf("%d = ",dec);
		int preI=1, preII=1;
		int index = 1;
		fibonaccimal[0] = 1;
		while(preI + preII <= dec){
			fibonaccimal[index] = preI + preII;
			preI = preII;
			preII = fibonaccimal[index];
			index++;
		}
		for(int i=index-1; i>=0; i--){
			if(dec >= fibonaccimal[i]){
				dec -= fibonaccimal[i];
				printf("1");
			}
			else{
				printf("0");
			}
		}
		printf(" (fib)\n");
	}




	return 0;
}
