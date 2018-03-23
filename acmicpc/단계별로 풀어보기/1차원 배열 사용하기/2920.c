#include <stdio.h>


int main() {
	int arr[8];
	int count_ascending = 0;
	int count_descending = 0;
	for (int i = 0; i < 8; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < 7; i++) {
		if (arr[i + 1] - arr[i] == 1) {
			count_ascending++;
		}
		else if (arr[i + 1] - arr[i] == -1) {
			count_descending++;
		}
	}
	if (count_ascending == 7)
		printf("ascending\n");
	else if (count_descending == 7)
		printf("descending\n");
	else
		printf("mixed");
	return 0;
}
