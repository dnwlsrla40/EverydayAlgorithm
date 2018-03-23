#include <stdio.h>
#include <string.h>
#define N 1000000

void RemoveEndSpaces(char *buf);

int main() {
	char arr[N-1];
	char *ptr;
	int i;
	int count = 0;
	scanf("%[^\n]", arr);
	RemoveEndSpaces(arr);
	ptr = strtok(arr, " ");
	while (ptr != NULL)
	{
		ptr = strtok(NULL, " ");
		count++;
	}
	printf("%d", count);
	return 0;
}

void RemoveEndSpaces(char *buf) {
	int i = 0;
	while (buf[i])
	{
		i++;
	}
	i--;
	while (buf[i] == ' ')
	{
		buf[i] == '\0';
		i--;
	}
}
