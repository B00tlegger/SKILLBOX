public class CardAccount extends BankAccount {

    @Override
    protected void take(double amountToTake) {
        super.take(amountToTake + (amountToTake / 100));
    }
}
