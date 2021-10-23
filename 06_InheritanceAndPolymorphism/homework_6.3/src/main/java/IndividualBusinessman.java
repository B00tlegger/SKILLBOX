public class IndividualBusinessman extends Client {
    @Override
    protected void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut - (amountToPut / 100));
        } else {
            super.put(amountToPut - (amountToPut / 100 * 0.5));
        }
    }

    @Override
    protected void accountInformation() {
        System.out.println("Счёт для бизнеса.\nДенег на счёте: " + getAmount() + "р." + "\nПополнение счёта - до 1000р. комиссия 1% \n\t\t\t\t   от 1000р. комиссия 0.5%" +
                "\nСнятие средств со счёта - комиссия 0%");
    }
}
