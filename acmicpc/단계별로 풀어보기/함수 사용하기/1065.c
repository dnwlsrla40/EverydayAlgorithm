#include <stdio.h>

bool checknumber(int N);

int main() {
	int N;
	int i;
	int count = 0;
	scanf("%d", &N);
	for (i = 1; i <= N; i++) {
		if (checknumber(i)) {
			count++;
		}
	}
	printf("%d", count);
	return 0;
}

bool checknumber(int N) {
	int a, b, c;
	if (N < 100) {
		return true;
	}
	else if (100 <= N) {
		a = N / 100;
		b = (N - a * 100) / 10;
		c = (N - a * 100 - b * 10);
		if ((a - b) == (b - c)) {
			return true;
		}
		else {
			return false;
		}
	}
}
