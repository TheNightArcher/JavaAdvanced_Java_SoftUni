package BankAccount_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
        while (!input.equals("End")) {
            String[] inputDate = input.split("\\s+");
            String command = inputDate[0];

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccountMap.put(account.getId(), account);
                    System.out.printf("Account ID%d created%n", account.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(inputDate[1]);
                    int amount = Integer.parseInt(inputDate[2]);

                    if (bankAccountMap.containsKey(id)){
                        bankAccountMap.get(id).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n",amount,id);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double insertSet = Double.parseDouble(inputDate[1]);
                    BankAccount.setInsertRate(insertSet);
                    break;
                case "GetInterest":
                    int idAcc = Integer.parseInt(inputDate[1]);
                    int years = Integer.parseInt(inputDate[2]);

                    if (bankAccountMap.containsKey(idAcc)){
                        double insert = bankAccountMap.get(idAcc).getInsert(years);
                        System.out.printf("%.2f%n",insert);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }




}
