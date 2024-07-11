#include <stdio.h>


int distance(int a, int b){

    return (a>b)? a-b:b-a;
}

int main(void) {

    int total;
    scanf("%d",&total);

    for(int i=0; i<total; i++){
        int sum;
        scanf("%d",&sum);
        int* nums = (int*)malloc(sum*sizeof(int));
        for(int j=0; j<sum; j++){
            int temp;
            scanf("%d",&temp);
            //�N0~j�i��Ƨ�
            if(j==0){nums[0] = temp;}
            else{
                //�Ntemp���J���T��m
                int s=j;//�Ů��m
                while(nums[s-1] > temp){
                    //�N�Ů楪��
                    nums[s] = nums[s-1];
                    s--;
                }
                nums[s] = temp;
            }

        }


        int middle = (sum%2 == 0)?nums[(sum/2) -1]:nums[sum/2];
        int total_distance = 0;
        for(int j=0; j<sum; j++){
            total_distance += distance(nums[j],middle);
        }
        printf("%d\n",total_distance);

        free(nums);
    }



  return 0;
}
