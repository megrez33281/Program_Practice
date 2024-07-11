#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int getNumber(char word){

	if('0' <= word && word <= '9'){
		return word-'0';
	}

	else if('A' <= word && word <= 'Z'){
		return word-'A'+10;
	}

	else if('a' <= word && word <= 'y'){
		return word-'a'+36;
	}

	else
		return -1;


}

int main(){
	char words[999];
	while(gets(words)){
		int max=0;
		int start = 0;
		for(int i=0; i<strlen(words); i++){
			int value = getNumber(words[i]);
			if(value > max){
				max = value;
			}
		}
		int base= (max > 1)?max+1:2;
		for(; base <= 62; base++){
			long long int dec = 0;
			long long int n=1;
			for(int j=strlen(words)-1; j>=0; j--){
				int value = getNumber(words[j]);
				if(value < 0){break;}
				dec += (value)*n;
				dec %= (base-1);    //���[�_�ӫ� mod (base-1) �M��mode(base-1)�A�[�_�ӵ��G�ۦP
				n *= base;
				n%=(base-1);        //�����_�ӫ� mod (base-1) �M��mode(base-1)�A���_�ӵ��G�ۦP
			}

			if(dec == 0){
				printf("%d\n",base);
				break;
			}
		}
		if(base > 62){
			printf("such number is impossible!\n");
		}


	}

	return 0;

}
