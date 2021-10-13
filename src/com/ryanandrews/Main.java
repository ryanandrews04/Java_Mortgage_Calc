package com.ryanandrews;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//Principal: 100000
//Annual Interest Rate: 3.92
//Period (Years): 30
//Mortgage: $472.81

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterest = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between $1,000 and $1,000,000");

        }
        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            if (monthlyInterest > 0 && monthlyInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }
        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        int months = years * MONTHS_IN_YEAR;

        double payment = principal
                         * (monthlyInterest * Math.pow(1 + monthlyInterest, months)
                         / ((Math.pow(1 + monthlyInterest, months))- 1));
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String paymentFormatted = currency.format(payment);
        System.out.print("Your monthly payment: " + paymentFormatted);
    }
}
