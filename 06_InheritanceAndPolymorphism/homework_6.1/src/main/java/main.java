public class main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();

        System.out.println("Средства на банковском счете: " + bankAccount.getAmount());
        bankAccount.put(1000);
        System.out.println("Средства на банковском счёте после внесения: " + bankAccount.getAmount());
        bankAccount.send(depositAccount, 500);
        bankAccount.send(cardAccount, 300);
        System.out.println("Средства на Ваших счетах:\n\tБанковский счёт: " + bankAccount.getAmount() + "\n\tКарточный счёт: " + cardAccount.getAmount() +
                "\n\tВклад: " + depositAccount.getAmount());
        cardAccount.take(250);
        System.out.println("С карты были списанны средства, остаток на карте: " + cardAccount.getAmount());
    }
}
