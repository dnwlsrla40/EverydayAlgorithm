#include <stdio.h>


int main() {
	int N, r = 0;
	int F;
	int count = 0;
	int a;
	scanf("%d", &N);
	F = N;
	do
	{
		if (N / 10 == 0) {
			r = N;
		}
		else {
			r = (N / 10) + (N % 10);
		}
		N = (N % 10) * 10 + (r % 10);
		count++;
	} while (N != F);
	printf("%d\n", count);
	scanf("%d", &a);

	return 0;
}
