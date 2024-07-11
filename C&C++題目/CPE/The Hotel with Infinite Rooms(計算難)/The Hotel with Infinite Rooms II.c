#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){

	long long int S,D;
	while(scanf("%lld %lld",&S,&D) != EOF){
		int days = 0;
		int n = (long long int) ceil((-1 + pow((1 - 4*S + 4*S*S + 8*D),0.5))/2);
					//n^2 + n -S^2 +S = 2D
					//n^2 + n  + (S - S^2 - 2D) = 0
				// n = ceil((-1 + (1 - 4S + 4S^2 + 8D)^0.5)/2) 
	
		
		printf("%d\n",n);
	
	
	}



	return 0;
}