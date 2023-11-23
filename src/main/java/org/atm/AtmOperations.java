package org.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmOperations implements AtmOPInterface{
    ATM atm = new ATM();

    Map<Double, String> ministmt = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("\nLoading Account Balance");
        System.out.println("Your Current Balance is: " + atm.getBalance());
        System.out.println();
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        Scanner scan = new Scanner(System.in);
        if(withdrawAmount%100 == 0) {
            if(withdrawAmount  <= atm.getBalance()) {
                System.out.println("Confirm ? Y/N");
                String confirm = scan.next();
                if(confirm.equals("Y")) {
                    ministmt.put(withdrawAmount, "Amount Withdrawn");
                    System.out.println("Collect the Cash" + withdrawAmount);
                    atm.setBalance(atm.getBalance() - withdrawAmount);
                    viewBalance();
                }
            }else{
                System.out.println("Insufficient Balance !!");
            }
        }else{
            System.out.println("Please Enter the amount in multiple of 100");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        System.out.println("Confirm? Y/N");
        Scanner scan = new Scanner(System.in);
        String confirm = scan.next();
        if(confirm.equals("Y")) {
            ministmt.put(depositAmount, "Amount Deposited");
            System.out.println(depositAmount + " Deposited Successfully!!");
            atm.setBalance(atm.getBalance() + depositAmount);
            viewBalance();
        }
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double, String> entry : ministmt.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
