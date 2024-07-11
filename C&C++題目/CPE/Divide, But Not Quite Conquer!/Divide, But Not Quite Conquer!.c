#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>


int main(){

	int m,n;
	while(scanf("%d %d",&n,&m) != EOF){
		int Q[999] = {0};
		Q[0] = n;
		int index = 1;
		bool flag = true;
		if(m == 1){
			printf("Boring!\n");
			flag = false;
		}
		int temp = n;
		while(flag && temp > 0){
			if(temp%m != 0 && temp != 1){
				printf("Boring!\n");
				flag = false;
				break;
			}
			Q[index++] = temp/m;
			temp/=m;
		}
		if(flag){
			for(int i=0; i<index-1; i++){
				printf("%d",Q[i]);
				if(i < index-2){
				printf(" ");}
			}
			printf("\n");

		}


	}

	return 0;
}
