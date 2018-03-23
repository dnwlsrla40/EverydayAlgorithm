#include <stdio.h>

int main() {
	int N,input,sum = 0;
	int i;
	scanf("%d", &N);
	for (i = 0; i < N; i++) {
		scanf("%1d", &input);
		sum += input;
	}
	printf("%d", sum);
	return 0;
}
