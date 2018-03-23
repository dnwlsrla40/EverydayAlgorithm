#include <stdio.h>

int main() {
	int num[26];
	char arr[100];
	for (int i = 0; i < 26; i++) {
		num[i] = -1;
	}
	scanf("%s", arr);
	for (int i = 0; i < 100; i++) {
		if (arr[i] == '\0')
			break;
		if (num[((int)arr[i] - 97)] == -1) {
			num[(int)arr[i] - 97] = i;
		}
	}
	for (int i = 0; i < 26; i++) {
		printf("%d ",num[i]);
	}
}
