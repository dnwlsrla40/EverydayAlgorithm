#include <stdio.h>

int main() {
  int N;
  int i,j,k;
  for(i=1; i<N; i++){
    for(j=N; j>i; j--){
      printf(" ");
    }
    printf("*");
    printf("\n");
  }
  return 0;
}
