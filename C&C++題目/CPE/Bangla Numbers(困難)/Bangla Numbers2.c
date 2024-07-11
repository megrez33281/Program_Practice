#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <stdbool.h>

void Bangla(long long number){

	if(number >= 10000000){
	
		Bangla(number/10000000);
		number %= 10000000;
		printf(" kuti");
	}
	if(number >= 100000){

		Bangla(number/100000);
		number %= 100000;
		printf(" lakh");
	
	}
	if(number >= 1000){

		Bangla(number/1000);
		number %= 1000;
		printf(" hajar");

	
	}
	
	if(number >= 100){

		Bangla(number/100);
		number %= 100;
		printf(" shata");
	
	}
   if(number > 0 ){
	
		printf(" %d",number);
	
	}



}


int main(){
	
	long long number;
	int Case=1;
	while(scanf("%lld",&number) != EOF){
		if(Case < 10){
			printf("   %d.",Case++);
		}
		else if(Case < 100){
			printf("  %d.",Case++);
		}
		else if(Case < 1000){
			printf(" %d.",Case++);
		}
		else if(Case < 10000){
			printf("%d.",Case++);
		}	
		if(number > 0){
			Bangla(number);}
		else{
			printf(" 0");
		}
		printf("\n");
	
	}
	
	return 0;
}