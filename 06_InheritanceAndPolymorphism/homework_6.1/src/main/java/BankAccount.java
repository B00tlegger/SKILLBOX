public class BankAccount {
    double moneyAmount;

    protected double getAmount() {
        return moneyAmount;
    }

    protected void put(double amountToPut) {
        if (amountToPut > 0) {
            moneyAmount += amountToPut;
        }
    }

    protected void take(double amountToTake) {
        if (amountToTake <= moneyAmount) {
            moneyAmount -= amountToTake;
        }
    }

    protected boolean send(BankAccount receiver, double amount) {
        boolean canSend = false;
        if (amount <= moneyAmount && amount > 0) {
            take(amount);
            receiver.put(amount);
            canSend = true;
        }
        return canSend;
    }
}
