#include <stdio.h>

int main() {
    int num1, num2, sum, difference;

    // Prompt the user for input
    printf("Enter two integers: ");

    // Read the input from the user
    scanf("%d %d", &num1, &num2);

    // Perform the addition and subtraction
    sum = num1 + num2;
    difference = num1 - num2;

    // Display the results
    printf("Sum = %d\n", sum);
    printf("Difference = %d\n", difference);

    return 0;
}
