#include <stdio.h>

int main() {
	int R,T;
	char S[100];
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d", &R);
		scanf("%s", S);
		for (int i = 0; i < 100; i++) {
			if (S[i] == '\0')
				break;
			for (int j = 0; j<R; j++) {
				printf("%c", S[i]);
			}
		}
		printf("\n");
		for (int i = 0; i < 100; i++) {
			S[i] = NULL;
		}
	}
}
