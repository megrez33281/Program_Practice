#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int main(){
	int Case;
	scanf("%d",&Case);
	while(Case--){  //case�ƶq
		int N;
		scanf("%d",&N);
		int parties;    //�F�Ҽ�
		scanf("%d",&parties);
		int hi[parties];    //�U�۬F�Ҫ�hartal
		for(int i=0; i<parties; i++){
			scanf("%d",&hi[i]);
		}
		int sum = 0;
		for(int i=1; i<=N; i++){
			if(i%7 == 6 || i%7 == 0){
				continue;}  //���p�J Sat �M Fri
			for(int j=0; j<parties; j++){
				if((i % hi[j]) == 0){
					sum++;
					break;  //�o��hartal
				}
			}
		}
		printf("%d\n",sum);


	}

	return 0;
}
