#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>


int main(){

	int N;
	while(scanf("%d ",&N) != EOF){
		if(N == 0){break;}
	    char rotate[10];
	    int up = 1;
		int north = 2;
		int west = 3;
		int east = 4;
		int south = 5;
		int down = 6;
	    while(N--){
	    	gets(rotate);
	    	if(rotate[0] == 'n'){
	    		int temp = north;
	    		north = up;
	  			up = south;
	  			south = down;
	  			down = temp;	    	
	    	}
	    	else if(rotate[0] == 'e'){
	    		int temp= east;
	    		east = up;
				up = west;
				west = down;
				down = temp;	    	
	    	}
	    	else if(rotate[0] == 's'){
	    		int temp = south;
	    		south = up;
	    		up = north;
	    		north = down;
	    		down = temp;   	
	    	}
	    	else if(rotate[0] == 'w'){
	    		int temp = west;
	    		west = up;
	    		up = east;
	    		east = down;
	    		down = temp;  		    	
	    	}
	    }
	    printf("%d\n",up);
		
	}


	return 0;
}