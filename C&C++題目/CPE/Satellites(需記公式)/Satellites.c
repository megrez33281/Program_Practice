#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define PI acos(-1)
#define degree PI/180
int main(){
	int s,a;

	char angletype[4];
	while(scanf("%d%d %s",&s,&a,&angletype) != EOF){
	
		if(angletype[0] == 'd'){
			printf("%f ",(double)(2*PI*(s+6440)*a/360));
			printf("%f\n",(double)(6440+s)*(sin(a*degree)/cos((a*0.5)*degree)));}
		
		else{
			printf("%f ",(double)(2*PI*(s+6440)*a/21600));
			printf("%f\n",(double)(6440+s)*(sin(a*degree/60)/cos((a*0.5)*degree/60)));}
		
		
		}
	


	return 0;	

}