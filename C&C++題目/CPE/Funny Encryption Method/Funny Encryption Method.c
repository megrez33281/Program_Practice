#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(){

	int T;
	scanf("%d",&T);
	while(T--){
		int dec;    //Ū���Q�i��
		scanf("%d",&dec);

		////���o�Q���i��
		int hex = 0;
		int temp = dec;
		int n=1;
		while(temp > 0){
			hex += (temp%10)*n;
			n*=16;
			temp /= 10;
		}

		//�p��1
		int decb = 0;
		int hexb = 0;
		while(dec >0){
			if(dec % 2 == 1){
				decb++;
			}
			dec /= 2;
		}

		while(hex >0){
			if(hex % 2 == 1){
				hexb++;
			}
			hex /= 2;
		}

		printf("%d %d\n",decb,hexb);


	}




	return 0;
}
