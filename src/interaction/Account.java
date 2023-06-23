package interaction;

import java.awt.image.PackedColorModel;
import java.util.Scanner;

public class Account extends AccountOwner {
    double balance;
    String pin;
    int accountNumber;
    Account(String firstName, String lastName, String phoneNumber, String pin) {
        super(firstName, lastName, phoneNumber);
        this.balance = 0;
        this.pin = pin;
        this.accountNumber = rnd(1000000, 9999999);
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public static void getPersonalBalance(int i) {
        System.out.println("Ваш баланс составляет " + Bank.allAccount[i].getBalance());
    }

    public static void upPersonalBalance(int i, double cash) {
        Bank.allAccount[i].balance = Bank.allAccount[i].balance + cash;
        System.out.println("Баланс пополнен на " + cash + ". Теперь ваш баланс составляет " + Bank.allAccount[i].getBalance());
    }

    public static void sendTo(int i, double cash, int cardNumberTo) {
        Bank.allAccount[i].balance = Bank.allAccount[i].balance - cash;
        for (int j = 0; j < Bank.allAccount.length; j++) {
            if (Bank.allAccount[j] != null) {
                if (Bank.allAccount[j].getAccountNumber() == cardNumberTo) {
                    Bank.allAccount[j].balance = Bank.allAccount[j].balance + cash;
                    System.out.println("Выполнен перевод " + Bank.allAccount[j].accountNumber + " в размере " + cash);
                }
            }
        }
    }

    public static void downPersonalBalance(int i, double cash) {
        if (Bank.allAccount[i].balance > cash) {
            Bank.allAccount[i].balance = Bank.allAccount[i].balance - cash;
            System.out.println("Вы сняли с баланса " + cash + ". Теперь ваш баланс составляет " + Bank.allAccount[i].getBalance());
        }
        else {
            System.out.println("На вашем балансе недостаточно средств для выполнения данной операции.");
        }
    }
}
