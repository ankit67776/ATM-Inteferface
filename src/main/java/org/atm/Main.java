package org.atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        AtmOPInterface op = new AtmOperations();
        int pin = 123;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Your Bank Amount !!!");

        while (true) {
            System.out.println("\nPress 1 to View Account Balance.\nPress 2 to Withdraw Amount.\nPress 3 to Deposit Amount.\nPress 4 to view Account" +
                    "Statement");
            System.out.println("Enter Choice: ");
            int choice = scan.nextInt();
            if(choice == 1) {
                System.out.println("Enter ATM Pin: ");
                int userPin = scan.nextInt();
                if(pin == userPin) {
                    System.out.println("Account Authorized!\n");
                    op.viewBalance();
                }else{
                    System.out.println("Incorrect PIN");
                    System.exit(0);
                }
            }

            else if(choice == 2) {
                System.out.println("Enter ATM Pin: ");
                int userPin = scan.nextInt();
                if(pin == userPin) {
                    System.out.println("Account Authorized");
                    System.out.println("Enter Withdraw Amount: ");
                    double withdrawAmount = scan.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }else{
                    System.out.println("Incorrect PIN");
                    System.exit(0);
                }
            }

            else if(choice == 3) {
                System.out.println("Enter the Pin: ");
                int userPIN = scan.nextInt();
                if(userPIN == pin) {
                    System.out.println("Account Authorized");
                    System.out.println("Enter Amount to Deposit: ");
                    double depositAmount = scan.nextDouble();
                    op.depositAmount(depositAmount);
                }else{
                    System.out.println("Incorrect PIN");
                    System.exit(0);
                }
            }

            else if(choice == 4) {
                System.out.println("Enter the Pin: ");
                int userPIN = scan.nextInt();
                if(userPIN == pin) {
                    System.out.println("Account Authorized");
                    op.viewMiniStatement();
                }else{
                    System.out.println("Incorrect PIN");
                    System.exit(0);
                }
            } else if (choice == 5) {
                System.out.println("Thanks for Visiting Us");
                System.exit(0);
            } else{
                System.out.println("Please Enter Valid Choice");

            }
        }
    }
}