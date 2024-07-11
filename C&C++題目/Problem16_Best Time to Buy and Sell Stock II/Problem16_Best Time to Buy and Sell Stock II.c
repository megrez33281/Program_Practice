#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define max(a,b) (a>b)?a:b
#define min(a,b) (a>b)?b:a


int maxProfit(int* prices, int pricesSize){
    int buy = 1;
    if(pricesSize < 2){
        return 0;
    }
    int pre = 0;
    int cur = 1;
    int profit = 0;
    int BuyIn = prices[0];
    int sale = 0;
    while (cur < pricesSize){
        if(buy == 1){
            if(prices[cur] < prices[pre]){
                BuyIn = prices[cur];
            }
            else if(prices[cur] > BuyIn){
                buy = 0;
                sale = prices[cur];
            }
        }
        else{
            if(prices[cur] > prices[pre]){
                sale = prices[cur];
            }
            else if(prices[cur] < sale){
                buy = 1;
                profit += sale - BuyIn;
                BuyIn = prices[cur];
                sale = 0;
            }
        }
        cur++;
        pre++;
    }
    if(buy == 0){
        profit += sale-BuyIn;
    }
    return profit;
}
int main() {

    int prices[6] = {7,1,5,3,6,4};
    int maximum = maxProfit(prices, 6);
    printf("%d\n", maximum);

    return 0;
}
