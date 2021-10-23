public class PhysicalPerson extends Client {
    @Override
    protected void accountInformation() {
        System.out.println("Счёт физического лица.\nДенег на счёте: " + getAmount() + "р." + "\nПополнение счёта - комиссия 0%\nСнятие средств со счёта - комиссия 0%");
    }
}
