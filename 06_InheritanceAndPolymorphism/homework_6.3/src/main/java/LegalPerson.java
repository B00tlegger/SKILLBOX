public class LegalPerson extends Client {
    @Override
    protected void take(double amountToTake) {
        super.take(amountToTake + (amountToTake / 100));
    }

    @Override
    protected void accountInformation() {
        System.out.println("Счёт юридического лица.\nДенег на счёте: " + getAmount() + "р." + "\nПополнение счёта - комиссия 0%\nСнятие средств со счёта - комиссия 1%");
    }
}
