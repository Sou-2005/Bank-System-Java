public class MainApp {

    public static void main(String[] args) {

        BankService bank = new BankService();

        bank.openAccount("AMIN", 1000, AccountType.STANDARD);
        bank.openAccount("SARAH", 2000, AccountType.PREMIUM);
        bank.openAccount("KARIM", 500, AccountType.STANDARD);

        bank.deposit("AMIN", 300);
        bank.withdraw("SARAH", 400);
        bank.transfer("AMIN", "KARIM", 200);

        bank.duplicateAccount("SARAH");

        bank.sendNotification(new SMSNotification(), "The operation was successful");
        bank.sendNotification(new EmailNotification(), "The account has been updated");

        bank.printAccounts();
    }
}
