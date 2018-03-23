#include <stdio.h>

int main() {
  int T;
  int i,a,b;
  scanf("%d",&T);
  for(i=0; i<T; i++){
    scanf("%d %d", &a, &b);
    printf("%d\n", a+b);
  }
  return 0;
}
