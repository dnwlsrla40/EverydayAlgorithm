#include <stdio.h>

int main() {
	int x, y, i;
	int cnt = 0;
	int month[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	scanf("%d %d", &x, &y);
	if (x == 1) {
		cnt += y;
	}
	else if (1 < x && x <= 12) {
		for (i = 0; i < x-1; i++)
		{
			cnt += month[i];
		}
		cnt += y;
	}
	switch (cnt % 7) {
	case 0:
		printf("SUN");
		break;
	case 1:
		printf("MON");
		break;
	case 2:
		printf("TUE");
		break;
	case 3:
		printf("WED");
		break;
	case 4:
		printf("THU");
		break;
	case 5:
		printf("FRI");
		break;
	case 6:
		printf("SAT");
		break;
	}
	return 0;
}
