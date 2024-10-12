/**
 * TwosComplementQuizzingProgram.java
 * <p>
 * This program quizzes users on converting to/from twos complement binary representation.
 * The user chooseS direction of conversion and is presented with 3 questions.
 * the program displays the user's score and asks if they would like to take another quiz.
 * <p>
 * Testing Scenarios:
 * 1. Answer all questions correctly and verify that the score is 3/3.
 * 2. Answer one question incorrectly and ensure that the score reflects 2/3.
 * 3. Answer all questions incorrectly and verify that the score is 0/3.
 * 4. Test input validation by providing non-integer inputs for integer questions.
 * 5. Test taking multiple quizzes to verify that the program correctly resets and processes new rounds.
 */

import java.util.Random;
import java.util.Scanner;

public class TwosComplement_Assignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean takeQuiz = true;

        showDirections();

        while (takeQuiz) {
            System.out.println("Choose the direction of conversion:");
            System.out.println("1. Convert decimal to two's complement.");
            System.out.println("2. Convert two's complement to decimal.");
            int choice = getAnswer("Enter 1 or 2: ", scanner);

            int score = 0;

            for (int i = 0; i < 3; i++) {
                if (choice == 1) {
                    score += askDecimalToTwosComplementQuestion(scanner) ? 1 : 0;
                } else if (choice == 2) {
                    score += askTwosComplementToDecimalQuestion(scanner) ? 1 : 0;
                }
            }

            System.out.println("You scored " + score + " out of 3.");
            System.out.print("Would you like to take another quiz? (yes/no): ");
            takeQuiz = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static void showDirections() {
        System.out.println("Welcome to the Two's Complement Quiz Program!");
        System.out.println("You will choose the direction of conversion and answer 3 questions.");
        System.out.println("The questions will involve converting between decimal and two's complement binary.");
        System.out.println("After answering, you will receive your score and the option to take another quiz.");
        System.out.println("Good luck!\n");
    }

    private static int getAnswer(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static boolean askDecimalToTwosComplementQuestion(Scanner scanner) {
        Random random = new Random();
        int number = random.nextInt(128) - 64;
        String correctAnswer = decimalToTwosComplement(number);

        System.out.print("Convert the decimal number " + number + " to two's complement (8-bit): ");
        String userAnswer = scanner.next();
        return userAnswer.equals(correctAnswer);
    }

    private static boolean askTwosComplementToDecimalQuestion(Scanner scanner) {
        Random random = new Random();
        int number = random.nextInt(128) - 64;
        String twosComplement = decimalToTwosComplement(number);

        System.out.print("Convert the two's complement binary " + twosComplement + " to decimal: ");
        int userAnswer = getAnswer("", scanner);
        return userAnswer == number;
    }

    private static String decimalToTwosComplement(int number) {
        String binaryString = Integer.toBinaryString(number & 0xFF);
        return String.format("%8s", binaryString).replace(' ', '0');
    }
}
