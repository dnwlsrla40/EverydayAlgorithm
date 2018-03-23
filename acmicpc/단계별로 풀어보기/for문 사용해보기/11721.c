#include <stdio.h>
#include <stdlib.h>

int main() {
	char* input;
	int N,i;
	input=(char*)malloc(sizeof(char)*10);
	scanf("%s", input);
	for(i = 0; input[i] != NULL; i++){
		printf("%c", input[i]);
		if(i%10 == 9)
			printf("\n");
    free(input);
    return 0;
	}
}
