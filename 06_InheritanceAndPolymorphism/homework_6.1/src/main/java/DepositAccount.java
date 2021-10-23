import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    protected void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    protected void take(double amountToTake) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(lastIncome.plus(1, MONTHS))) {
            super.take(amountToTake);
        }
    }
}
