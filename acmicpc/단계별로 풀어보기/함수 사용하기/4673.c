#include <stdio.h>
#include <stdlib.h>

#define N 10001

int selfnumber(int n);

int main() {
	bool* arr;
	int idx;
	int i;
	arr = (bool*)malloc(sizeof(bool)*N);
	for (i = 0; i < N; i++) {
		arr[i] = false;
	}
	for (i = 1; i < N; i++) {
		idx = selfnumber(i);
		if (idx <= N) {
			arr[idx] = true;
		}
	}

	for (i = 1; i < N; i++) {
		if (!arr[i]) {
			printf("%d\n", i);
		}
	}
	return 0;
}

int selfnumber(int n) {
	int sum = n;
	while (1) {
		if (n == 0) {
			break;
		}
		sum += n % 10;
		n = n / 10;
	}
	return sum;
}
