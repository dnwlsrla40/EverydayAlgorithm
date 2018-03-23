#include <stdio.h>
int main() {
  int N;
  int i,j,k;
  scanf("%d", &N);
  for(i=N; i>=1; i--){
    for(j=1; j<=N-i; j++){
      printf(" ");
    }
    for(k=1; k<=i; k++){
      printf("*");
    }
    printf("\n");
  }
  return 0;
}
