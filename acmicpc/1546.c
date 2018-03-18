#include <stdio.h>
#include <stdlib.h>

int main() {
	int i, input;
	int Max=0;
	int N = 0;
	double* arr;
	double average = 0;
	double sum = 0;

	scanf("%d", &N);
	arr = (double*)malloc(sizeof(double)*N);

	for (i = 0; i<N; i++) {
		scanf("%d", &input);
		arr[i] = input;
		if (i == 0)
			Max = arr[i];
		else if (arr[i] > Max)
			Max = arr[i];
	}
	for (i = 0; i < N; i++) {
		arr[i] = arr[i] * 100 / Max;
		sum += arr[i];
	}
	average = sum / N;
	printf("%.2lf", average);
	return 0;
}
