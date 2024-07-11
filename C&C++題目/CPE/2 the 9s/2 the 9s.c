#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>


int main(){
	char numbers[1001]= {};
	
	while(gets(numbers)){
		int len = strlen(numbers);
		if(numbers[0] == '0'){
			break;
		}
		printf("%s ",numbers);
		int digitsum = 0;
		int degree=1;
		for(int i=0; i<len; i++){
			digitsum += (numbers[i]-'0');
		}
		int recursive = digitsum;
		while(recursive > 10){
			digitsum =0;
			while(recursive > 0){
				digitsum += (recursive%10);
				recursive/=10;
			
			}
			recursive = digitsum;
			degree++;
		}
		
		

		if(recursive == 9){
			printf("is a multiple of 9 and has 9-degree %d.\n",degree);
		
		}
		else{
			printf("is not a multiple of 9.\n");
		}
	
	
	}







}