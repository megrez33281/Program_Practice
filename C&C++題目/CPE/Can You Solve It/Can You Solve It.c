#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(){

	int Case;
	scanf("%d",&Case);
	for(int i=1; i<=Case; i++){
		int sx,sy,dx,dy;
		scanf("%d%d%d%d",&sx,&sy,&dx,&dy);
		printf("Case %d: ",i);
		int step=0;
		int starty=sx + sy;
		bool flag = false;

		while(flag == false){
			for(int j=sx+1; j<=starty; j++){
				if(flag == false){
					sx=j;
					sy=starty-j;
					step++;
				}
				if(sx == dx && sy==dy){
					flag = true;
					break;
				}
			}
			if(flag == false){
				starty++;
				step++;
				sx=0;
				sy=starty;
                if(sx == dx && sy==dy){
                    flag=true;
                }
			}

		}
		printf("%d\n",step);




	}
	return 0;
}
