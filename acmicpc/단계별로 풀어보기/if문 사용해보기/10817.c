#include <stdio.h>

int main() {
  int A,B,C;
  scanf("%d %d %d", &A, &B, &C);
  if(A>=B && A<=C){
    printf("%d\n", A);
  }
  else if(A>=C && A<=B){
    printf("%d\n", A);
  }
  else if(B>=A && B<=C){
    printf("%d\n", B);
  }
  else if(B>=C && B<=A){
    printf("%d\n", B);
  }
  else if(C>=A && C<=B){
    printf("%d\n", C);
  }
  else if(C>=B && C<=A){
    printf("%d\n", C);
  }
  return 0;
}
