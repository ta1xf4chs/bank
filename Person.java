class Person {
    public String fName, lName, noID, gender;

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlName() {
        return lName;
    }

    public void setNoID(String noID) {
        this.noID = noID;
    }

    public String getNoID() {
        return noID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    void printInfo() {
        System.out.println(this.fName + " is  first name");
        System.out.println(this.lName + " is  last name");
        System.out.println(this.noID + " is  NO. ID");
        System.out.println(this.gender + " is  gender");
    }

}

class Account extends Person {
    public String getNoID() {
        return noID;
    }

    boolean isValid() {
        return isValidName() && isValidAccountNumber() && isValidPassword();
    }

    boolean isValidName() {
        return fName.length() <= 50;
    }

    boolean isValidAccountNumber() {
        return noID.length() == 13;
    }

    boolean isValidPassword() {
        return password.length() == 4;
    }

    void checkMoney() {
        int moneyMax = 1000000;
        if (this.balance > moneyMax) {
            this.balance = 1000000;
            System.out.println("!!!WARNING!!! Money in your account is set to 1M bath");
        }
    }

    void show() {
        System.out.println(this.fName + " is name account");
        System.out.println(this.noID + " is number account");
        System.out.println(this.password + " is password account now");
        System.out.println(this.balance + " bath is money in account");
        System.out.println("---------------------------------");
    }

    public String login, password;
    public float balance;

    public Account(String fName, String lName, String no, String gender, String pwd, float money) {
        this.fName = fName;
        this.lName = lName;
        this.noID = no;
        this.gender = gender;
        this.password = pwd;
        this.balance = money;
    }
}

class Manager extends Person {
    String login = "";
    String password = "";
}