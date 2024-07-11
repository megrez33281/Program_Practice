#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

bool IsPrime(int num){
	
	if(num == 2 || num == 3){
		return true;
	}
	for(int i=2; i<=ceil(pow(num,0.5)); i++){
		if(num%i == 0){
			return false;
		}
	
	
	}

	return true;

}



int main(){
	
	int num;
	while(scanf("%d",&num) != EOF){
		printf("%d ",num);
		if(IsPrime(num)){
			int reverse = 0;
			int temp = num;
			while(num > 0){
				reverse*=10;
				reverse += num%10;
				num /=10;
			}
			if(reverse != temp && IsPrime(reverse)){
				printf("is emirp.\n");
			}
			
			else{
				printf("is prime.\n");
			}
		
		
		}
		
		else{
			printf("is not prime.\n");
		}
	
	
	
	
	
	}


	return 0;
}