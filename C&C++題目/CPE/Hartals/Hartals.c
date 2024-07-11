#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int main(){
	int Case;
	scanf("%d",&Case);
	while(Case--){  //case數量
		int N;
		scanf("%d",&N);
		int parties;    //政黨數
		scanf("%d",&parties);
		int hi[parties];    //各自政黨的hartal
		for(int i=0; i<parties; i++){
			scanf("%d",&hi[i]);
		}
		int sum = 0;
		for(int i=1; i<=N; i++){
			if(i%7 == 6 || i%7 == 0){
				continue;}  //不計入 Sat 和 Fri
			for(int j=0; j<parties; j++){
				if((i % hi[j]) == 0){
					sum++;
					break;  //發生hartal
				}
			}
		}
		printf("%d\n",sum);


	}

	return 0;
}
