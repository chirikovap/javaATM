import interaction.ATM;
import interaction.Account;
import interaction.Bank;
import interaction.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOperation = -1;
        int numberOperationP = -1;
        while (numberOperation != 5) {
            ATM.showMainMenu();
            Scanner scannerMain = new Scanner(System.in);
            System.out.println("Выберите операцию и введите соответствующее ей число:");
            numberOperation = scannerMain.nextInt();
            if (numberOperation == 3) {
                Bank.addAccount();
            }
            if (numberOperation == 2) {
                System.out.println("На данный момент были выполнены следующие операции:");
                System.out.println(Transaction.getTransactions());
            }
            if (numberOperation == 4) {
                Bank.SeeAllAccount();
            }
            if (numberOperation == 1) {
                ATM.verifyAccountAndPin();
                if (ATM.entryError == 0) {
                    while (numberOperationP != 5) {
                        ATM.showPersonalMenu();
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Выберите операцию и введите соответствующее ей число:");
                        numberOperationP = scanner2.nextInt();
                        if (numberOperationP == 4) {
                            Account.getPersonalBalance(ATM.indexInArray);
                        }
                        if (numberOperationP == 1) {
                            Scanner scannerCash = new Scanner(System.in);
                            System.out.println("Введите сумму наличных, на которую хотите пополнить баланс");
                            double cash = scannerCash.nextDouble();
                            Account.upPersonalBalance(ATM.indexInArray, cash);
                            Transaction.allTransactions.add(Bank.allAccount[ATM.indexInArray].getAccountNumber() + " пополнил(а) баланс на " + Double.toString(cash));
                        }
                        if (numberOperationP == 2) {
                            Scanner scannerCash = new Scanner(System.in);
                            System.out.println("Введите сумму наличных, которую хотите снять с баланса");
                            double cash = scannerCash.nextDouble();
                            Account.downPersonalBalance(ATM.indexInArray, cash);
                            Transaction.allTransactions.add(Bank.allAccount[ATM.indexInArray].getAccountNumber() + " снял(а) с баланса " + Double.toString(cash));
                        }
                        if (numberOperationP == 3) {
                            Scanner scannerCash = new Scanner(System.in);
                            System.out.println("Введите сумму наличных, которую хотите перевести");
                            double cash = scannerCash.nextDouble();
                            Scanner scannerCardN = new Scanner(System.in);
                            System.out.println("Введите номер карты, на которую хотите совершить перевод");
                            int cardNumberTo = scannerCardN.nextInt();
                            Account.sendTo(ATM.indexInArray, cash, cardNumberTo);
                            Transaction.allTransactions.add(Bank.allAccount[ATM.indexInArray].getAccountNumber() + " перевел средства на сумму " + cash);
                            Transaction.allTransactions.add(cardNumberTo + " получил средства на сумму " + cash);
                        }
                    }
                    if (numberOperationP == 5) {
                        System.out.println("До встречи!");
                        numberOperationP = -1;
                        continue;
                    }
                }
                if (ATM.entryError == 1) {
                    ATM.showMainMenu();
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Выберите операцию и введите соответствующее ей число:");
                    numberOperation = scanner2.nextInt();
                }
            }
        }
        System.out.println("До свидания!");
    }
}