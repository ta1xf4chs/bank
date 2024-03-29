import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        int a = 1, c = 1;
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Manager manaderUser = new Manager();
        boolean st_manager = false;
        while (a == 1) {
            System.out.println("---------------------------------");
            System.out.println("1: create manager account ");
            System.out.println("2: login for manager");
            System.out.println("3: exit");

            System.out.print("mode: ");
            int mode = scanner.nextInt();
            switch (mode) {
                case 2:
                    System.out.println("mode: 2");
                    System.out.println("---------------------------------");
                    System.out.println("***LOGIN FOR MANAGER***");
                    System.out.print("Input login: ");
                    String login1 = scanner.next();
                    System.out.print("Input password: ");
                    String password1 = scanner.next();
                    if (login1.equals(manaderUser.login) && password1.equals(manaderUser.password)) {
                        System.out.println("_____correct_____");
                        st_manager = true;
                        a = 0;
                    } else {
                        System.out.println("_____incorrect_____");
                    }
                    break;
                case 1:
                    System.out.println("create manager account");
                    System.out.print("Input first name: ");
                    String fname = scanner.next();
                    System.out.print("Input last name: ");
                    String lname = scanner.next();
                    System.out.print("Input id: ");
                    String id = scanner.next();
                    System.out.print("Input gender: ");
                    String gender = scanner.next();
                    System.out.print("Input login: ");
                    String login = scanner.next();
                    System.out.print("Input password: ");
                    String password = scanner.next();
                    manaderUser.fName = fname;
                    manaderUser.lName = lname;
                    manaderUser.noID = id;
                    manaderUser.gender = gender;
                    manaderUser.login = login;
                    manaderUser.password = password;
                    break;
                case 3:
                    System.out.println("end");
                    a = 0;
                    break;
                default:
                    mode = 3;
                    a = 0;
                    c = 0;
            }
        }

        // สร้างผู้ใช้
        if (st_manager) {
            System.out.print("How many create account(maximum is 5): ");
            int x = scanner.nextInt();
            if (x <= 5 && x > 0) {
                for (int i = 0; i < x; i++) {
                    System.out.println("***CREATE ACCOUNT***");
                    System.out.print("Input fName: ");
                    String fName = scanner.next();
                    System.out.print("Input lName: ");
                    String lName = scanner.next();
                    System.out.print("Input gender: ");
                    String gender = scanner.next();
                    System.out.print("Account number (13 digits): ");
                    String no = scanner.next();
                    while (no.length() != 13 || checkAccNo(accounts, no)) {
                        if (no.length() != 13) {
                            System.out.println("Account number must be 13 digits. Please try again.");
                        } else {
                            System.out.println("Account number is already taken. Please try again.");
                        }
                        System.out.print("Account number (13 digits): ");
                        no = scanner.next();
                    }
                    System.out.print("Password (4 digits): ");
                    String pwd = scanner.next();
                    while (pwd.length() != 4) {
                        System.out.println("Password must be 4 digits. Please try again.");
                        System.out.print("Password (4 digits): ");
                        pwd = scanner.next();
                    }
                    System.out.print("Money: ");
                    float money = scanner.nextFloat();
                    Account newAccount = new Account(fName, lName, no, gender, pwd, money);
                    if (newAccount.isValid()) {
                        accounts.add(newAccount);
                        System.out.println("***ACCOUNT CREATED***");
                    } else {
                        System.out.println("!!!WARNING!!! Account not created. Please check input.");
                    }
                    System.out.println("---------------------------------");
                }
                System.out.println("***DISPLAY ALL ACCOUNTS***");
                for (Account account : accounts) {
                    account.show();
                }
            } else {
                System.out.println("At max 5 account OR please input integer");
                c = 0;
            }
        }
        System.out.print("Please enter BTC rate => ");
        float BTC_rate = scanner.nextFloat();
        System.out.println("1 BTC = " + BTC_rate + "bath ");

        // user login
        while (c == 1) {
            System.out.println("***LOGIN FOR USER***");
            System.out.print("login_user(13 digits) = ");
            String login_user = scanner.next();
            System.out.print("login_password(4 digits) = ");
            String login_password = scanner.next();
            for (Account data : accounts) {
                if (data.noID.equals(login_user) && data.password.equals(login_password)) {
                    while (true) {
                        ATMAction p2 = new ATMAction();
                        p2.showATMAction(accounts, scanner, login_user, BTC_rate);
                        break;
                    }
                }
            }
        }
    }

    private static boolean checkAccNo(ArrayList<Account> accounts, String accountNumber) {
        for (Account account : accounts) {
            if (account.getNoID().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
}
