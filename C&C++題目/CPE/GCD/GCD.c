#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int GCD(int m, int n){
	int r = m%n;
	while(r > 0){
		m = n;
		n = r;
		r = m%n;
	}

	return n;
}

int main(){

	int N;
	while(scanf("%d",&N) != EOF){
		if(N == 0){
			break;
		}
		int G = 0;
		for(int i=1; i<N; i++){
			for(int j=i+1; j<=N; j++){
			G += GCD(i,j);
			}
		}
		printf("%d\n",G);
	
	}
	return 0;
}