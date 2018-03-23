#include <stdio.h>
#include <stdlib.h>

int main() {
	int C, N;
	int j, k;
	int input;
	int* arr;

	scanf("%d", &C);
	while(C--) {
		float average = 0;
		float count = 0;
		scanf("%d", &N);
		arr = (int*)malloc(sizeof(int)*N);
		for (j = 0; j < N; j++) {
			scanf("%d", &input);
			arr[j] = input;
			average += input;
		}
		average /= N;
		for (k = 0; k < N; k++) {
			if (arr[k] > average)
				count++;
		}
		printf("%.3f%%\n", count * 100 / N);
		free(arr);
	}
	return 0;
}
