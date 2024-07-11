/*You are given a 0-indexed integer array nums of length n.

The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.

Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

Note:

The absolute difference of two numbers is the absolute value of their difference.
The average of n elements is the sum of the n elements divided (integer division) by n.
The average of 0 elements is considered to be 0.*/

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define max(a,b) (a>b)?a:b


int minimumAverageDifference(int* nums, int numsSize){

    int max_index = 0;

    long long int left_sum = 0;
    long long int right_sum = 0;
    for(int i=0; i<numsSize; i++){
        right_sum += nums[i];
    }
    int min = -1;
    for(int index=0; index<numsSize; index++){
        left_sum += nums[index];
        right_sum -= nums[index];
        long long int left_mean = floor(left_sum/(index+1));
        long long int right_mean = (right_sum==0)?0:floor(right_sum/(numsSize-index-1));
        int dis = abs(left_mean-right_mean);
        if(min == -1 || dis < min){
            min = dis;
            max_index = index;
            if(min == 0){
                return max_index;
            }
        }

    }
    return max_index;
}

int main() {

    int Test;
    scanf("%d",&Test);
    while(Test--){
        int n;
        scanf("%d",&n);
        int* nums = (int*)calloc(n,sizeof(int));
        for(int i=0; i<n; i++){
            scanf("%d",nums+i);
        }
        int max_index = minimumAverageDifference(nums,n);
        printf("%d\n",max_index);
        free(nums);

    }



    return 0;
}
