#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

#define PI (double)acos(-1)

double getDegree(int angle, char type){
	//2 PI = 360 dgree
	// 1 degree = PI/180 rad

	if(type ==  'd'){
		
		return (double)angle*(PI/180);
	}

	else if(type == 'm'){

		return (double)angle*(PI/180)/60;
	
	
	}



}

int main(){

    int r,angle;
    char type[5]={0};
    while(scanf("%d %d %s",&r,&angle,&type) != EOF){
    	r += 6440;
    	
    	if(type[0] == 'd'){
    		printf("%llf ", 2*r*PI*angle/360);
    	}
    	else if(type[0] == 'm'){
    		printf("%llf ", 2*r*PI*angle/360/60);
    	}
    	
    	//a/sinA = b/sinB
    	//a = sinA*(b/sinB)
    	// a = sinA*(r/cos(A/2))
    	double degree = getDegree(angle,type[0]);
    	printf("%llf\n",sin(degree)*r/cos((double)degree/2) );
    
    
    
    
    }


	return 0;
}