#include <stdio.h>
#include <string.h>
#include <stdbool.h>



int main(){

	int Case;
	int index = 1;
	scanf("%d",&Case);
	while(Case--){
		printf("Case %d:\n",index++);
		int costs[36];
		for(int i=0; i<36; i++){
			scanf("%d",&costs[i]);
		}
		int N;
		scanf("%d",&N);
		while(N--){
			int number; //decimal format
			scanf("%d",&number);
			printf("Cheapest base(s) for number %d:",number);
			int cheapestbase[36] = {0};
			int baseIndex = 0;
			int cheapest = -1;
			for(int i=2; i<=36; i++){
				int sum = 0;
				int temp = number;
				while(temp > 0){
					sum += (costs[temp%i]);
					temp /= i;
				}
				if(cheapest == -1){
					cheapest = sum;
					cheapestbase[baseIndex++] = i;
				}
				else if(sum < cheapest){
					cheapest = sum;
					cheapestbase[0] = i;
					baseIndex = 1;
				}
				else if(sum == cheapest){
					cheapestbase[baseIndex++] = i;

				}


			}
			for(int i=0; i<baseIndex; i++){
				printf(" %d",cheapestbase[i]);
			}
			printf("\n");

		}
		if(Case > 0){
			printf("\n");
		}


	}


	return 0;
}
