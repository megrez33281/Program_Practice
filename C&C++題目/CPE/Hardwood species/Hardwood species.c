#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>

int IsEqual(char* str1,int len1, char* str2, int len2){
	int min = (len1 > len2)?len2:len1;
	for(int i=0; i<min; i++){
		if(str1[i] > str2[i]){
			return 1;
		}
		else if(str1[i] < str2[i]){
			return -1;
		}
	}
	if(len1 > len2){
		return 1;
	}
	else if(len1 < len2){
		return -1;
	}
	return 0;

}

void copy(char* source,char* dest, int len){
	for(int i=0; i<len; i++){
		dest[i]=source[i];
	
	
	}


}

int main(){
	int Case;
	int flag=0;
	scanf("%d ",&Case);
	char** trees = (char**)calloc(1000000,sizeof(char*));
	for(int i=0; i<10000; i++){
		trees[i] = (char*)calloc(31,sizeof(char));
	
	}
	while(Case--){
		int index = 0;
		if(flag >0){
			printf("\n");
		}
		else{
			flag=1;
		}
		while(gets(trees[index])){
			if(strlen(trees[index]) == 0){
				break;
			}
			index++;	
		}
		//sort
		for(int i=index-1; i>=0; i--){
			for(int j=1; j<=i; j++){
				if(IsEqual(trees[j],strlen(trees[j]),trees[j-1],strlen(trees[j-1])) == -1){
					char temp[31];
					copy(trees[j],temp,31);
					copy(trees[j-1],trees[j],31);
					copy(temp,trees[j-1],31);
				}
			
			
			}
		
		
		}
		
		int i=0;
		int amount=1;
		while(i < index){
			if(i+1 < index && IsEqual(trees[i],strlen(trees[i]),trees[i+1],strlen(trees[i+1])) == 0){
				amount++;
				i++;
			}
			else{
				float ratio = (float)amount/index;
				ratio*=100;
				printf("%s %.4f\n",trees[i],ratio);
				amount=1;
				i++;
			
			}
		
		
		}
	
	}
	free(trees);
	return 0;
}