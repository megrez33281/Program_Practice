#include <stdio.h>


int main(void) {

  int a,b;
  while(scanf("%d %d",&a,&b) != EOF){
    if(a==0 && b==0){break;}

    int carry = 0;
    int total = 0;
    while(a !=0 || b!=0){
         //�ˬd�ثe��Ƭۥ[�O�_�i��
        if(a%10 +b%10+carry >= 10){
            carry = 1;//�Y�|�i��h�U�@��Ʒ|���@��carry
            total ++; //�i�쪺�ƶq
        }
        else{
            carry = 0; //�M��carry
        }
        a /= 10;
        b /= 10;
    }
    printf("a:%d b:%d\n",a,b);
    if(a+b+carry >= 10){total++;}//�ˬd�̰��쪺�i��
    if(total == 0){
        printf("No carry operation.\n");
    }
    else if(total == 1){
        printf("1 carry operation.\n");
    }
    else{
        printf("%d carry operations.\n",total);
    }

  }



  return 0;
}
