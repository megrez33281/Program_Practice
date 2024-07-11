#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){
	int boundedx; //bounded of rectangle
	int boundedy; 
	scanf("%d %d ",&boundedx, &boundedy);
	int locx,locy;
	char direction;
	char ins[101]={0};
	int scentIndex = 0;
	int scent[300][2] = {0};
	while(scanf("%d%d ",&locx,&locy) != EOF){
		
		bool lost = false;
		scanf("%c ",&direction);
		gets(ins);
		//printf("inc:%s\n",ins);
	    char direct[4] = {'N','E','S','W'};
	    int directpoint=0;
	    //get the direct point of the robot
	    for(int i=0; i<4; i++){
	    	if(direct[i] == direction){
	    		directpoint = i;
	    	}
	    }
	    //printf("strlen:%d\n",strlen(ins));
	    for(int i=0; i<strlen(ins) && lost ==false ; i++){
	    	if(ins[i] == 'R'){
	    		directpoint++;
	    		directpoint %= 4;
	    	}
	    	else if(ins[i] == 'L'){
	    		directpoint--;
	    		if(directpoint <0){
	    			directpoint = 3;
	    		}
	    	
	    	}
	    	
	    	else if(ins[i] == 'F'){
	    		//Forward
	    		switch(direct[directpoint]){
	    			case 'E':{
	    					locx++;
	    					if(locx > boundedx){locx = boundedx; lost = true;}
	    					break;}
	    				
	    			case 'S':{
	    					locy--;
	    					if(locy < 0 ){locy = 0; lost = true;}
	    					break;}
	    			case 'W':{
	    					locx--;
	    					if(locx < 0 ){locx = 0; lost = true;}
	    					break;}
	    			case 'N':{
	    					locy++;
	    					if(locy > boundedy){locy = boundedy; lost = true;}
	    					break;}
	    				default:break;
	   			}

	    	}
	    	
	    	if(lost){
	    		//if there is scent the robot won't lost
	    		int j=0;
	    		
	    		for( ;j<scentIndex; j++){
	    			//printf("%d\n",scentIndex);
	    			if(scent[j][0] == locx && scent[j][1] == locy){
	    				lost = false;
	    				
	    			}
	    		}
	    		if(j == scentIndex){
	    			scent[j][0] = locx;
	    			scent[j][1] = locy;
	    			scentIndex++;
	    			//printf("%d %d %d\n",scent[j][0],scent[j][1],scentIndex);
	    		}
	    	
	    	}
	    	//printf("dir:%c x=%d y=%d lost:%d ins:%c\n",direct[directpoint],locx,locy,lost,ins[i]);
	    
	    }
		printf("%d %d %c",locx,locy,direct[directpoint]);
		if(lost){
			printf(" LOST");
		}
		printf("\n");
	
	}
	return 0; 
}