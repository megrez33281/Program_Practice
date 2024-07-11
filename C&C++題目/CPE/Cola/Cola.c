#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

int main(){
	int N;
	while(scanf("%d",&N) != EOF){
		int empty = 0;
		int drink1 = 0;
		int full = N;
		//method 1
		while(full + empty >= 3){
			drink1 += full;	//drink
			empty += full;  //full bottle
			full = 0; //drink all cola
			full += empty/3; //3 empty bottl get 1 cola
			empty %= 3; //the empty bottle after get full cola
		}
		drink1 += full; // leftover cola
		empty += full;
		full = 0;
		//now, the empty bottle will left 0 or 1 or 2, only when you have 2 empty bottle you can borrow the bottle
		if(empty <= 1){
			printf("%d\n",drink1);
		}

		else{
			printf("%d\n",drink1+1); //when you have two empty bottle, you can bororrow one bottle
		}

	}

	return 0;
}
