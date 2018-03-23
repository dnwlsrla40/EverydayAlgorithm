#include <stdio.h>
#include <string.h>
#define N 1000000


void checknumber(int result);

int main() {
	int A, B, C;
	int result = 0;
	scanf("%d %d %d", &A, &B, &C);
	result = A*B*C;
	checknumber(result);
}

void checknumber(int result) {
	int number = 0;
	int zero = 0;
	int one = 0;
	int two = 0;
	int three = 0;
	int four = 0;
	int five = 0;
	int six = 0;
	int seven = 0;
	int eight = 0;
	int nine = 0;
	while (1) {
		number = result % 10;
		result = result / 10;
		switch (number) {
		case 0:
			zero++;
			break;
		case 1:
			one++;
			break;
		case 2:
			two++;
			break;
		case 3:
			three++;
			break;
		case 4:
			four++;
			break;
		case 5:
			five++;
			break;
		case 6:
			six++;
			break;
		case 7:
			seven++;
			break;
		case 8:
			eight++;
			break;
		case 9:
			nine++;
			break;
		}
		if (result == 0) {
			break;
		}
	}
	printf("%d\n", zero);
	printf("%d\n", one);
	printf("%d\n", two);
	printf("%d\n", three);
	printf("%d\n", four);
	printf("%d\n", five);
	printf("%d\n", six);
	printf("%d\n", seven);
	printf("%d\n", eight);
	printf("%d\n", nine);
}
