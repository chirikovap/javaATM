package interaction;

import java.util.Scanner;

public class ATM {
    public static int indexInArray = -1;
    public static int entryError;
    public static void showMainMenu() {
        System.out.println("Выберите действие:\n1. ВХОД\n2. Вывод всех транзакций\n3. Создать новый счёт\n4. Вывести все существующие счета\n5. ВЫХОД");
    }

    public static void showPersonalMenu() {
        System.out.println("Выберите действие:\n1. Пополнить баланс\n2. Снять наличные\n3. Перевести средства\n4. Показать баланс\n5. ВЫХОД");
    }

    public static void verifyAccountAndPin() {
        entryError = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер карты:");
        int an = scanner.nextInt();
        indexInArray = -1;
        for (int i = 0; i < Bank.allAccount.length; i++) {
            if (Bank.allAccount[i] != null) {
                if (Bank.allAccount[i].getAccountNumber() == an) {
                    indexInArray = i;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите PIN:");
                    String pin = scanner1.nextLine();
                    if (Bank.allAccount[i].getPin().equals(pin)) {
                        System.out.println("ВХОД выполнен успешно! Добро пожаловать " + Bank.allAccount[i].getFirstName() + "!");
                    } else {
                        entryError = 1;
                        System.out.println("PIN неверный!");
                    }
                    break;
                }
            }
        }
        if (indexInArray == -1) {
            entryError = 1;
            System.out.println("Аккаунта с таким номером карты не существует!");
        }
    }
}
