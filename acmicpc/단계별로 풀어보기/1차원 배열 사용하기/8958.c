#include <stdio.h>


int main() {
	int T;
	int count;
	char arr[80] = "";
	int sum;
	scanf("%d", &T);
	while (T) {
		T--;
		scanf("%s", &arr);
		count = 0;
		sum = 0;
		for (int i = 0; i < 79; i++) {
			if (arr[i] == '\0')
				break;
			else if (arr[i] == 'O') {
				count++;
				sum += count;
			}
			else if (arr[i] == 'X') {
				count = 0;
			}
		}
		printf("%d\n", sum);
	}
}
