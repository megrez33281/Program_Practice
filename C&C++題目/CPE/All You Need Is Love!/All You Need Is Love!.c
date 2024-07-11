#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){

	int Case;
	scanf("%d ",&Case);
	for(int i=1; i<=Case; i++){
		// find factor that both S1 and S2 has
		char S1[31], S2[31];
		gets(S1);
		gets(S2);
		int S1dec = 0;
		int S2dec = 0;
		int product = 1;
		for(int j=strlen(S1)-1; j>=0; j--){
			S1dec += (S1[j]-'0')*product;
			product*=2;
		}
		product = 1;
		for(int j=strlen(S2)-1; j>=0; j--){
			S2dec += (S2[j]-'0')*product;
			product*=2;
		}

		//用輾轉相除法找到最小公因數
		int r = S1dec % S2dec;
		while(r != 0){
			S1dec = S2dec;
			S2dec = r;
			r = S1dec%S2dec;

		}

		if(S2dec > 1){
			printf("Pair #%d: All you need is love!\n",i);
		}
		else{
			printf("Pair #%d: Love is not all you need!\n",i);
		}

	}


	return 0;
}
