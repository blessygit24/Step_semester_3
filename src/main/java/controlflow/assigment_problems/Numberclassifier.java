package main.java.controlflow.assigment_problems;

import java.util.Scanner;

class NumberClassifier {

    void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } 
        else if (number < 0) {
            System.out.println("Negative");
        } 
        else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        NumberClassifier obj = new NumberClassifier();
        obj.classifyNumber(number);

        sc.close();
    }
}

