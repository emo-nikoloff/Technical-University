/*Дефинирайте */
#include <stdio.h>

int main(void)
{
    int a;
    double b;
    char c;

    int *p1 = &a;
    printf("%p ", p1);
    printf("%p\n", &a);
    double *p2 = &b;
    printf("%p ", p2);
    printf("%p\n", &b);
    char *p3 = &c;
    printf("%p ", p3);
    printf("%p\n", &c);

    *p1 = 10;
    *p2 = 10.5;
    *p3 = 'a';

    printf("%d ", a);
    printf("%lf ", b);
    printf("%c\n", c);

    p1++;
    p2++;
    p3++;
    printf("%p ", p1);
    printf("%p\n", p2);
    printf("%p\n", p3);
}
