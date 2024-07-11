#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int IsEqual(char* str1, int len1, char* str2, int len2){
	int min = (len1 >  len2)?len2:len1;
	for(int i=0; i<min; i++){
		if(str1[i] > str2[i]){
			return 1;
		}
		else if(str1[i] < str2[i]){
			return -1;
		}
	}
	if(len1 == len2){
		return 0;
	}
	else if(len1 > len2){
		return 1;
	}
	else{
		return -1;
	}


}


int main(){

	int Case;
	scanf("%d",&Case);
	char Conquests[999][10]={};
	char garbage[100];
	int index=0;
	while(Case--){
		scanf("%s", &Conquests[index++]);
		gets(garbage);
	}
	for(int i=index-1; i>=0; i--){
		for(int j=1; j<=i; j++){
			if(IsEqual(Conquests[j],strlen(Conquests[j]),Conquests[j-1],strlen(Conquests[j-1])) == -1){
				char temp[10]={0};
				for(int k=0; k<strlen(Conquests[j]); k++){
					temp[k] = Conquests[j][k];
				}
				for(int k=0; k < 10; k++){
					Conquests[j][k] = Conquests[j-1][k];
				}
				for(int k=0; k < 10; k++){
				   Conquests[j-1][k] = temp[k] ;
				}
			
			
			}
		
		}
	
	}
	
	int count = 1;
	for(int i=0; i<index; i++){
		if(i+1 < index && IsEqual(Conquests[i],strlen(Conquests[i]),Conquests[i+1],strlen(Conquests[i+1])) == 0){
			count++;
		}
	
		else{
			printf("%s %d\n", Conquests[i],count);
			count = 1;	
		}
	
	}
	
	return 0;
}