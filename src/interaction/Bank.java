package interaction;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
    public static Account [] allAccount = new Account[10];
    public static void addAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя:");
        String firstName = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите Вашу фамилию:");
        String lastName = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Введите Ваш номер телефона:");
        String phoneNumber = scanner2.nextLine();
        AccountOwner example = new AccountOwner(firstName, lastName, phoneNumber);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Придумайте PIN:");
        String pin = scanner3.nextLine();
        Account example2 = new Account(firstName, lastName, phoneNumber, pin);
        for (int i = 0; i< allAccount.length; i++) {
            if (allAccount[i] == null) {
                allAccount[i] = example2;
                break;
            }
        }
        System.out.println("Аккаунт успешно создан! Номер - " + example2.accountNumber);
    }
    public static void SeeAllAccount() {
        for (int i = 0; i < allAccount.length; i++) {
            if (allAccount[i] != null) {
                System.out.println(allAccount[i].getFirstName() + " " + allAccount[i].getLastName() + " " + allAccount[i].getPhoneNumber() + " " + allAccount[i].getAccountNumber() + "\n");
            }
        }
    }
}
