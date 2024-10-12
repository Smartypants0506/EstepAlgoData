#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <stdint.h>

void showDirections();
int getAnswer(char *string);
bool decimalToTwosComplement();
bool twosComplementToDecimal();
void printBinary(int8_t number);
int decimalToTwosComplementConverter(int8_t number);

char choiceString[] = "Enter 1 or 2: ";

int main() {
    int takeQuiz = 1;

    showDirections();

    while (takeQuiz) {
        printf("Choose direction of conversion\n");
        printf("1. Convert decimal to two's complement.\n");
        printf("2. Convert two's complement to decimal.\n");
        int choice = getAnswer(choiceString);

        int score = 0;

        for (int i = 0; i < 3; i++) {
            if (choice == 1) {
                score += decimalToTwosComplement() ? 1 : 0;
            } else if (choice == 2) {
                score += twosComplementToDecimal() ? 1 : 0;
            } else {
                printf("Invalid choice :(");
                exit(0);
            }
        }

        printf("You scored %i out of 3.\n", score);
        printf("Would you like to take another quiz (1 for yes, 0 for no): ");
        scanf("%i", &takeQuiz);
    }

    printf("Thanks for playing\n");
}

void showDirections() {
    printf("Welcome to the Two's Complement Quiz Program!\n");
    printf("You will choose the direction of conversion and answer 3 questions.\n");
    printf("The questions will involve converting between decimal and two's complement binary.\n");
    printf("After answering, you will receive your score and the option to take another quiz.\n");
}

int getAnswer(char *string) {
    while (1) {
        int ans;
        printf("%s", string);
        if (scanf("%i", &ans) == 1) {
            return ans;
        } else {
            printf("Invalid input. Please enter a valid integer.\n");
            while (getchar() != '\n'); // Clear the input buffer
        }
    }
}

bool decimalToTwosComplement() {
    int num = rand() % (127 - (-127) + 1) + (-127);
    int userAnswer;
    int correctAnswer = decimalToTwosComplementConverter(num);

    printf("Convert the decimal number %i to two's complement (8 bits): ", num);
    printBinary((int8_t) correctAnswer);
    printf("\nYour answer (in decimal): ");
    scanf("%i", &userAnswer);

    return correctAnswer == userAnswer;
}

bool twosComplementToDecimal() {
    int num = rand() % (127 - (-127) + 1) + (-127);
    int userAnswer;
    int number = decimalToTwosComplementConverter(num);

    printf("Convert the two's complement binary ");
    printBinary((int8_t) number);
    printf(" back to decimal: ");
    scanf("%i", &userAnswer);

    return num == userAnswer;
}

int decimalToTwosComplementConverter(int8_t number) {return (int) number & 0xFF;}

void printBinary(int8_t number) {
    for (int i = 7; i >= 0; i--) {
        printf("%d", (number >> i) & 1);
    }
}
