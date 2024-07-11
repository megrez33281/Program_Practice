#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

int main(){
   // 0 1 2
   // 0  1 2
   // 0 1  2
   //
	int points,edge;
	
	while(scanf("%d",&points) != EOF){
	    if(points == 0){break;}
	    scanf("%d",&edge);
	    int** edges = (int**)calloc(edge,sizeof(int**));

	    for(int i=0; i<edge; i++){
			edges[i] = (int*)calloc(2,sizeof(int));
			scanf("%d %d",&edges[i][0],&edges[i][1]);
		}
	    /*for(int i=0; i<edge; i++){
	    	printf("%d %d\n",edges[i][0],edges[i][1]);
	    }
	    printf("\n");*/

		int* Tpoints = (int*)calloc(points,sizeof(int));
	    int* queue = (int*)calloc(9999,sizeof(int*));
	    int head = 0;
		//assume there are color 1 and color -1
		int color = 1;
		Tpoints[0] = color;
		color = Tpoints[0]*-1;
		int draw = 1;
		for(int i=0; i<edge; i++){
			if(edges[i][0] == 0){
				queue[head++] = edges[i][1];
				Tpoints[edges[i][1]] = color;
				draw++;
			}
			else if(edges[i][1] == 0){
				queue[head++] = edges[i][0];
				Tpoints[edges[i][0]] = color;
				draw++;
			}
		}
		int tail = 0;
		bool flag = true;
		while(draw < points){
			/*for(int i=0; i<points; i++){
				printf("%d ",Tpoints[i]);
			}
			printf("\n");*/
			int nowpoint = queue[tail++];
			color = Tpoints[nowpoint]*-1;
			for(int i=0; i<edge && draw < points; i++){
				//printf("nowpoint:%d nowedge:%d %d\n",nowpoint,edges[i][0],edges[i][1]);
				if(edges[i][0] == nowpoint && Tpoints[edges[i][1]] == 0){
					queue[head++] = edges[i][1];
					Tpoints[edges[i][1]] = color;
					draw++;
					
				}
				else if(edges[i][1] == nowpoint && Tpoints[edges[i][0]] ==  0 ){
					queue[head++] = edges[i][0];
					Tpoints[edges[i][0]] = color;
					draw++;
				    
				}
			}
			color*=-1;
		
		
		}
		

		
	
		for(int i=0; i<edge; i++){
			int index1 = edges[i][0];
			int index2 = edges[i][1];
			if(Tpoints[index1] == Tpoints[index2]){
				flag = false;
			}
		}
		
		if(flag){
			printf("BICOLORABLE.\n");
		}
		
		else{
			printf("NOT BICOLORABLE.\n");
		}
		
		/*for(int i=0; i<edge; i++){
			printf("%d %d %d\n",edges[i][0],edges[i][1],edges[i][2]);
		}
		printf("choose = %d\n",choose);*/
	
		free(queue);
		free(Tpoints);
		free(edges);
	}
	return 0;
}