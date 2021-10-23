import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, Account> blockedAccount = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void addAccount(String accountNumber, long moneyAmount) {
        Account account = new Account(accountNumber, moneyAmount);
        accounts.put(account.getAccNumber(), account);
    }


    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        long balanceAfterWithdrawal = fromAccount.getMoney() - amount;
        long balanceAfterDeposit = toAccount.getMoney() + amount;
        if(fromAccount.getMoney() > toAccount.getMoney()){
        synchronized (fromAccount) {
            synchronized (toAccount){
                doTransfer(fromAccount, toAccount, amount, balanceAfterWithdrawal, balanceAfterDeposit);
            }
        }
        }else {
            synchronized (toAccount){
                synchronized (fromAccount){
                    doTransfer(fromAccount, toAccount, amount, balanceAfterWithdrawal, balanceAfterDeposit);
                }
            }
        }
    }

    private void doTransfer(Account fromAccount, Account toAccount, long amount, long balanceAfterWithdrawal, long balanceAfterDeposit){
        if (amount >= 50000) {
            try {
                if (isFraud(fromAccount.getAccNumber(), toAccount.getAccNumber(), amount) == true) {
                    blockedAccount.put(fromAccount.getAccNumber(), fromAccount);
                    blockedAccount.put(toAccount.getAccNumber(), toAccount);
                    System.out.println("Аккаунт " + fromAccount.getAccNumber() + " заблокирован.\nАккаунт " + toAccount.getAccNumber() + " заблокирован");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (blockedAccount.containsKey(fromAccount.getAccNumber())) {
            System.out.println("невозможно осуществить перевод, Ваш аккаунт заблокирован");
        } else if (fromAccount.getMoney() < amount) {
            System.out.println("Невозможно осуществить перевод, на счету недостаточно средств");
        } else if (amount < 1) {
            System.out.println("Невозможно произвести операцию, сумма не должна быть меньше одного рубля");
        } else {
            fromAccount.setMoney(balanceAfterWithdrawal);
            toAccount.setMoney(balanceAfterDeposit);
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong sumAllAccounts = new AtomicLong();
        accounts.forEach((s, account) -> sumAllAccounts.addAndGet(account.getMoney()));
        return sumAllAccounts.get();
    }

    public String accNumberGenerator() {
        StringBuilder accNumber = new StringBuilder();
        for (int b = 0; b < 4; b++) {
            StringBuilder block = new StringBuilder();
            for (int num = 0; num < 4; num++) {
                int number = (int) (10 * Math.random());
                if (number == 10) {
                    number = number - 1;
                }
                block.append(number);
            }
            accNumber.append(block).append(" ");
        }
        return accNumber.toString().trim();
    }

    public List<String> getAccNumbers() {
        List<String> accNumbers = new ArrayList<>();
        for (String key : accounts.keySet()) {
            accNumbers.add(key);
        }
        return accNumbers;
    }
}

