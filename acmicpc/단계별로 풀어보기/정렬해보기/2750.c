#include <stdio.h>

int* Qsort(int* arr, int N);

int main() {
	int N;
	int arr[1000];
	int input;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &input);
		arr[i] = input;
	}
	Qsort(arr, N);
	for (int i = 0; i < N; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;
}

int* Qsort(int* arr, int N) {
	int temp;
	for (int i = N-1; i >= 0; i--) {
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
			}
		}
	}
	return arr;
}
