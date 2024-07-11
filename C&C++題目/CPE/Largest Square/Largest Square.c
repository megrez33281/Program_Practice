#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>


int main(){
	
	int Case;
	scanf("%d",&Case);
	while(Case--){
	
		int M,N,Q;
		scanf("%d%d%d ",&M,&N,&Q);
		printf("%d %d %d\n",M,N,Q);
		char arrays[101][101] = {};
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				scanf("%c ",&arrays[i][j]);
			}
		}
		
		while(Q--){
			int r,c;
			scanf("%d %d",&r,&c);
			char center = arrays[r][c];
			int Max_len = (r > M-r)?M-r:r;
			int Max_wid = (c > N-c)?N-c:c;
			int Max_r = (Max_len > Max_wid)?Max_wid:Max_len;
			int row = c-Max_r;
			bool flag = true;
			while(flag){
				flag = false;
				for(int i= r-Max_r; i <=r+Max_r; i++){
					for(int j= c-Max_r; j<= c+Max_r; j++)
						if(center != arrays[i][j]){
							Max_r--;
							flag = true;
							break;
						}
				}
				
			
			}
			printf("%d\n",2*Max_r +1);
		
		
		
		}
	
	
	
	
	
	}



	return 0;
}