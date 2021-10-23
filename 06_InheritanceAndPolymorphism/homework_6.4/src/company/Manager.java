package company;

public class Manager implements Employee {

    Company company;
    double salary = 25000;
    double monthSalary;
    double moneyAmount = 115000 + 25 * Math.random();

    public Manager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        monthSalary = Math.round((salary + moneyAmount / 100 * 5) * Math.pow(10, 2)) / Math.pow(10, 2);
        return monthSalary;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(Employee o) {
        if (getMonthSalary() > o.getMonthSalary()) {
            return 1;
        }
        if (getMonthSalary() < o.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
