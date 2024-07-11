#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>

void press(int* fingers, char note){
	if(note == 'c'){
		char finger[] = "01110011111";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'd'){
		char finger[] = "0111001110";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'e'){
		char finger[] = "0111001100";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'f'){
		char finger[] = "0111001000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'g'){
		char finger[] = "0111000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'a'){
		char finger[] = "0110000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'b'){
		char finger[] = "0100000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'C'){
		char finger[] = "0010000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'D'){
		char finger[] = "1111001110";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'E'){
		char finger[] = "1111001100";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  
  else if(note == 'F'){
		char finger[] = "1111001000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'G'){
		char finger[] = "1111000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'A'){
		char finger[] = "1110000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }
  else if(note == 'B'){
		char finger[] = "1100000000";
		for(int i=0; i<10; i++){
			fingers[i] = (finger[i]-'0');
		}
  }







}

int main(){

	int Case;
	scanf("%d ",&Case);
	while(Case--){
		char notes[201];
		gets(notes);
		int* finger = (int*)calloc(10,sizeof(int));
		int* before = (int*)calloc(10,sizeof(int));
		int tablet[10] = {0};
		for(int i=0; i<strlen(notes); i++){
			press(finger,notes[i]);
			for(int j=0; j<10; j++){
				if(finger[j] == 1 && before[j] == 0){
					tablet[j]++;
				}
				before[j] = finger[j];
			}
		}
		for(int i=0; i<10; i++){
			printf("%d",tablet[i]);
			if(i != 9){
				printf(" ");
			}
		}
		printf("\n");
	
	}
	return 0;
}