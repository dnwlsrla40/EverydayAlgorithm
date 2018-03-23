#include <stdio.h>
#include <stdlib.h>

int main() {
	int N, X, i, input;
	int* A;
	scanf("%d", &N);
	A = (int*)malloc(sizeof(int)*N);
	scanf("%d", &X);
	for (i = 0; i < N; i++) {
		scanf("%d", &input);
		A[i] = input;
		if (A[i] < X) {
			printf("%d ", A[i]);
		}
	}
	printf("\n");
	return 0;
}
