#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define max(a,b) (a>b)?a:b
#define min(a,b) (a>b)?b:a

void exchange(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;

}
void quickSort(int* nums, int start, int end){
    if(start >= end){
        return;
    }
    int left=start;
    int right=end;
    int pivot = nums[left];

    while(left < right){
        while(left < right && nums[right] > pivot){
            right--;
        }

        while(left < right && nums[left] <= pivot){
            left++;
        }
        if(left != right){
            exchange(nums+left,nums+right);
        }
    }
    exchange(nums+start,nums+left);
    quickSort(nums,start,left-1);
    quickSort(nums,left+1,end);

}

int longestConsecutive(int* nums, int numsSize){
    if(numsSize <= 1){
        return numsSize;
    }

    //�Nnums�i�����
    int* largestArray = (int*)calloc((int)numsSize/2 +1,sizeof(int));
    int* smallestArray = (int*)calloc((int)numsSize/2 +1, sizeof(int));
    int amounts = 0;
    for(int i=0; i<numsSize; i++){
        int flag = 0; //�ΥH�P�_��e�����O�_���էO
        for(int j=0; j<amounts; j++){
            if(nums[i] > largestArray[j] && nums[i]-largestArray[j] <= 100000){
                largestArray[j] = nums[i];
                flag = 1;
                break;
            }
            else if(nums[i] < smallestArray[j] && smallestArray[j]-nums[i] <= 100000){
                smallestArray[j] = nums[i];
                flag = 1;
                break;
            }
            else if(nums[i]>=smallestArray[j] && nums[i]<= largestArray[j]){
                flag=1;
                break;
            }
        }
        if(flag == 0){
            largestArray[amounts] = nums[i];
            smallestArray[amounts] = nums[i];
            amounts++;
        }
    }

    //�M���U�էO�íp��̪��ǦC
    int longest = 0;
    for(int group=0; group<amounts; group++){
        int largest = largestArray[group];
        int smallest = smallestArray[group];
        int size;
        int deviation = smallest*-1; //�i�氾���A�Ϲ����쪺�̤pindex��0
        int* hashSet;
        if(smallest >= 0){
            size = largest-smallest+1;
            hashSet = (int*)calloc(size,sizeof(int));

        }
        else{
            size = smallest*-1 + largest+1;
            hashSet = (int*)calloc(size,sizeof(int));
        }
        int index;
        for(int i=0; i<numsSize; i++){
            if(nums[i] < smallest || nums[i] > largest){
                continue;
            }
            index = nums[i] + deviation;
            hashSet[index] = 1;
        }

        //�̧Ǳqnums����X�����A�æbhashSet���p��t�Ӥ������̪��ǦC
        //�p��ɹJ�쪺nums���������|�Q�аO�A�Ϩ�b�M���ɤ��|�A�Q���
        int cur = 0;
        for(int i=0; i<numsSize; i++){
            if(nums[i] < smallest || nums[i] > largest){
                continue;
            }
            index = nums[i] + deviation;
            if(hashSet[index] == -1){//�аO���w�p��L
                continue;
            }
            int left = index-1;
            int right = index;
            while(left >= 0 && hashSet[left] == 1){
                hashSet[left] = -1;
                left--;
            }
            while(right < size && hashSet[right] == 1){
                hashSet[right] = -1;
                right++;
            }
            cur = right-left-1;
            if(cur > longest){
                longest = cur;
            }
        }
        free(hashSet);
    }

    free(largestArray);
    free(smallestArray);
    return longest;
}

int main() {

    int numsSize = 11;
    int nums[] = {-8,-4,9,9,4,6,1,-4,-1,6,8}; //-8 -4 -4 -1 1 4 6 6 8 9 9
    printf("%d\n", longestConsecutive(nums,numsSize));

    return 0;
}
