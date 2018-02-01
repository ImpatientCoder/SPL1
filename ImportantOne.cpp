#include<stdio.h>

int main()
{
    int i = 1;
    printf("%d %d %d\n", i, ++i, i++);

    printf("%d", i);

    //(printf functin got this parameters according to i++, ++i, i)
    //3 3 1
}
