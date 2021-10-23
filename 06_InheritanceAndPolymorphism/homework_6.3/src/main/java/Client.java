public abstract class Client {
    protected double moneyAmount;

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

    abstract protected void accountInformation();

    protected void setMoney(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
