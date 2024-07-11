#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>


int main(){

	char words[1000];
	int flag = 0;
	while(gets(words)){
		if(flag > 0){printf("\n");}
		else{
			flag = 1;
		}
		int arrays[1000][2] = {0};
		for(int i=0; i<strlen(words); i++){
			arrays[words[i]][1]++;
			arrays[words[i]][0] = words[i];	
		}
		
		for(int i=999; i>=0; i--){
			for(int j=1; j<=i; j++){
				if(arrays[j][1] < arrays[j-1][1] || (arrays[j][1] == arrays[j-1][1]) && arrays[j][0] > arrays[j-1][0]){
					int acsii = arrays[j][0];
					int amount = arrays[j][1];
					arrays[j][0] = arrays[j-1][0];
					arrays[j][1] = arrays[j-1][1];
					arrays[j-1][0] = acsii;
					arrays[j-1][1] = amount;
				}
			}
		}
		for(int i=0; i<1000; i++){
			if(arrays[i][1] > 0){
				printf("%d %d\n",arrays[i][0],arrays[i][1]);
			
			
			}
		
		}
	
	}

	return 0;
}