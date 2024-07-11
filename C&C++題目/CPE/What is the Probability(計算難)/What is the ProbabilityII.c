#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

int main(){
	
	int Case;
	scanf("%d",&Case);
	while(Case--){
		int players,player;
		float p;
		scanf("%d %f %d",&players,&p,&player);		
		//Probability: (1-p)^(player-1)*p + (1-p)^(player-1)*(1-p)^players*p + (1-p)^(player-1)*(1-p)^2players*p + ....
		//a1 = (1-p)^(player-1)*p   r= (1-p)^players n = infinite
		// S = a1*((1-r^n)/(1-r))
		// n ~ infinite : S = a1*((1)/(1-r)) = a1/(1-r)
		
		if(p > 0){
			printf("%.4f\n",(float)(pow(1-p,player-1)*p)/(1-pow(1-p,players)));
		}

		
		else{
			printf("0.0000\n");
		
		}
		
	
	
	
	}
	
	return 0;
}