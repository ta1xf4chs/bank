import java.util.ArrayList;
import java.util.Scanner;

public class ATMAction {
    Account login_user;
    int b;
    Account ToUser;

    public void showATMAction(ArrayList<Account> accounts, Scanner scanner, String login_user, float BTC_rate) {
        for (Account data : accounts) {
            if (data.noID.equals(login_user)) {
                this.login_user = data;
            }
        }

        this.b = 1;
        while (this.b == 1) {
            System.out.println("****** SELECT MODE ******");
            System.out.println("*      1:Checkable      *");
            System.out.println("*    2:Withdrawable     *");
            System.out.println("*     3:Depositable     *");
            System.out.println("*    4:Transferable     *");
            System.out.println("********  5:EXIT ********");
            float BTC_money = this.login_user.balance / BTC_rate;

            System.out.print("SELECT MODE: ");
            int SELECT = scanner.nextInt();
            switch (SELECT) {
                case 1:
                    while (true) {
                        System.out.println("First Name: " + this.login_user.fName);
                        System.out.println("Last Name: " + this.login_user.lName);
                        System.out.println("Balance(bath): " + this.login_user.balance);
                        System.out.println("Balance(BTC): " + BTC_money);
                        System.out.println("********  0:Back ********");
                        if (scanner.nextInt() == 0)
                            break;
                    }
                    break;
                case 2:
                    System.out.println("******* MONEY MODE ******");
                    System.out.println("*         1:bath        *");
                    System.out.println("*         2:BTC         *");
                    System.out.println("********  0:EXIT ********");
                    System.out.print("MONEY MODE: ");
                    int MONEY_MODE = scanner.nextInt();
                    switch (MONEY_MODE) {
                        case 1:
                            System.out.print("Enter Withdrawable(bath) : ");
                            float drawable = scanner.nextInt();
                            while (drawable > this.login_user.balance) {
                                System.out.print(" ***NOT enough***Input money again :");
                                drawable = scanner.nextInt();
                            }
                            this.login_user.balance -= drawable;
                            break;
                        case 2:
                            System.out.print("Enter Withdrawable(BTC) : ");
                            float BTC_drawable = scanner.nextInt();
                            while (BTC_drawable > BTC_money) {
                                System.out.print(" ***NOT enough***Input money again :");
                                BTC_drawable = scanner.nextInt();
                            }
                            this.login_user.balance -= BTC_drawable * BTC_rate;
                            break;
                        default:
                            MONEY_MODE = 0;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter Depositable : ");
                    this.login_user.balance += scanner.nextInt();
                    break;
                case 4:
                    boolean find = false;
                    while (true) {
                        System.out.println("---Transferable---");
                        System.out.print("Transfer To (id 13 digits): ");
                        String TT = scanner.next();
                        for (Account data : accounts) {
                            if (data.noID.equals(TT)) {
                                find = true;
                                this.ToUser = data;
                            }
                        }
                        if (find) {
                            System.out.println("find! Account");
                            System.out.println("TO Name :" + this.ToUser.fName);
                            System.out.println("TO Last Name :" + this.ToUser.lName);
                            System.out.print("Input money transfer :");
                            int monTo = scanner.nextInt();
                            while (monTo > this.login_user.balance) {
                                System.out.print(" ***NOT enough***Input money again :");
                                monTo = scanner.nextInt();
                            }
                            this.ToUser.balance += monTo;
                            this.login_user.balance -= monTo;
                            break;
                        } else {
                            System.out.println("Not find! Account");
                            break;
                        }
                    }
                    break;
                case 5:
                    this.b = 0;
                    break;
                default:
                    SELECT = 5;
                    this.b = 0;
            }
        }
    }
}
