#include <stdio.h>
#include <string.h>
#include <stdbool.h>



int main(void) {
    char day[7][10] = {"Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};
    int days[12] = {31,28,31,30,31,30,31,31,30,31,30,31};//2011年個月的天數
    int sum;
    scanf("%d",&sum);
    for(int i=0; i<sum; i++){
        int month;
        int date;
        scanf("%d%d",&month,&date);
        int sum_day = 0;

        //計算輸入日期與2010年12月31日的天數差距
        for(int j=1; j<=month; j++){
            if(j < month){
                sum_day += days[j-1];
            }
            else if(j == month){
                sum_day += date;
            }
        }
        sum_day%=7;
        printf("%s\n",day[sum_day]);
    }
    return 0;
}
