#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){

	float x[4];
	float y[4];
	while(scanf("%f %f %f %f %f %f %f %f",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3]) != EOF){
		int repeat = -1;
		if((x[0] == x[1] && y[0] == y[1]) || (x[0] == x[2] && y[0] == y[2]) || (x[0] == x[3] && y[0] == y[3])){
			repeat = 0;
		}
		else if((x[1] == x[2] && y[1] == y[2]) || (x[1] == x[3] && y[1] == y[3])){
			repeat = 1;
		}
		else if(x[2] == x[3] && y[2] == y[3]){
			repeat = 2;
		}
		//printf("repeat: %f %f\n",x[j],y[j]);
		//sumx = startIx + startIIx +endx   sumy = startIy + startIIy + endy
		 //startIx + startIIx - endx, startIy + startIIy - endy
		printf("%.3f %.3f\n",x[0] +x[1] +x[2]+ x[3] - 3*x[repeat], y[0] + y[1] + y[2] + y[3] - 3*y[repeat]);
	
	
	
	}
	return 0;
}